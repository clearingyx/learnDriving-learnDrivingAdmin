package com.net.crud.handlers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.Driving;
import com.net.crud.modal.OrderDrivingProgress;
import com.net.crud.modal.OrderPayProgress;
import com.net.crud.modal.Orders;
import com.net.crud.modal.Person;
import com.net.crud.modal.Score;
import com.net.util.UUIDHashCode;

@Controller
public class OrdersHandler extends BaseHandler{
	
	//订单列表
	@ResponseBody
	@RequestMapping("ordersListByPid")
	public Object OrdersListByPid(Integer p_id,Integer pageIndex,Map<String, Object> map){
		map.put("p_id", p_id);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		return  ordersDao.OrderListByPid(map);
	}
	
	//分期列表
	@ResponseBody
	@RequestMapping("orderPayProgress")
	public Object orderPayProgress(Integer order_id){
		return orderPayProgressDao.orderPayProgress(order_id);
	}
	
	//课程列表
	@ResponseBody
	@RequestMapping("orderDrivingProgress")
	public Object orderDrivingProgress(Integer order_id){
		Integer progress_name = orderDrivingProgressDao.orderDrivingProgress(order_id);
		if(progress_name==null || progress_name<1) return "warning";
		else	return progress_name;
	}
	
	//评价
	@ResponseBody
	@RequestMapping("orderScore")
	public Object orderScore(Orders o,Score s){
		try{
			String p_photo=s.getP_photo();
			if(p_photo==null || "".equals(p_photo.trim())){
				s.setApi_p_photo("/learnDriving/upload/default.png");
			}else{
				s.setApi_p_photo(getNewName(p_photo).trim());
			}
			s.setP_photo("");//会自动装载对象将localhost也放进去，所以只好在起一个实体属性
			int a = 0;
			float f = 0.0f;
			//驾校
			if(s.getType()==1){
				s.setOther_id(o.getDriving_id());
			}
			//陪练
			if(s.getType()==2){
				s.setType(3);
				s.setOther_id(o.getSparring_id());
			}
			//教练
			if(s.getType()==5){
				s.setType(2);
				s.setOther_id(o.getCoach_id());
			}
			a = scoreDao.insert(s);
			f = scoreDao.selectScoreAve(s);
			if(s.getType()==1){
				Driving d  = new Driving();
				d.setId(s.getOther_id());
				d.setScore(f);
				a = drivingDao.update(d);
			}else{
				Person p = new Person();
				p.setId(s.getOther_id());
				p.setScore(f);
				a = personDao.update(p);
			}
			if(a>0 && s.getType()!=5){
				//更新订单状态为9
				Orders or = new Orders();
				or.setId(s.getOrder_id());
				or.setDriving_state(9);
				a = ordersDao.update(or);
			}
			return result(a);
		}catch (Exception e) {
			return "error";
		}
	}
	//驾校支付
	@ResponseBody
	@RequestMapping("drivingPay")
	public String drivingPay(Orders o){//installment_state,order_sn
		int a = 0;
		if(o.getInstallment_state()!=null && o.getInstallment_state()==4){//是分期，并且分期审核通过
			OrderPayProgress opp = orderPayProgressDao.selectByProgressSn(o.getOrder_sn());
			OrderPayProgress oopp = new OrderPayProgress(opp.getId(), 1);//1是待支付
			a = orderPayProgressDao.updateNotFirst(oopp);
		}else{
			o = ordersDao.selectByOrderSn(o.getOrder_sn());//不是分期
			Orders oo = new Orders(o.getId(), 1, new Date());//1是待支付
			a = ordersDao.update(oo);
		}
		return result(a);
	}
	
	//陪练生成订单
	@ResponseBody
	@RequestMapping("sparringReg")
	public String sparringReg(Orders o){
		String sn=UUIDHashCode.getOrderIdByUUId();
		o.setOrder_sn(sn);//uuid订单号
		o.setPay_state(1);//待支付
		o.setType(2);
		int a = ordersDao.insert(o);
		if(a>0) return sn;
		return "fail";
	}
	/*
	 * 订单支付相关
	 */
	//支付成功
	//查看是全额还是分期，通过订单号查询然后插入支付宝号，并且更新状态。如果是分期，则更新两个表的状态。
	public void PaySuccess(String order_sn,String alipay_sn){
		Orders o = ordersDao.selectByOrderSn(order_sn);
		if(o==null){//分期
			OrderPayProgress opp = orderPayProgressDao.selectByProgressSn(order_sn);
			//通过订单号找到是否最后一个分期
			List<OrderPayProgress> list = orderPayProgressDao.orderPayProgress(opp.getOrder_id());
			OrderPayProgress oopp = new OrderPayProgress(opp.getId(), 3);//3-支付成功
			oopp.setPay_date(new Date());
			oopp.setAlipay_sn(alipay_sn);
			/*if(opp.getSeveral_stages()==1){//第一次支付，除了分期表，还要更新订单表
				oopp.setOrder_id(opp.getOrder_id());
				orderPayProgressDao.updateFirst(oopp);
			}else*/ if(opp.getSeveral_stages()==list.size()){//最后一个分期，也要更新订单表
				oopp.setOrder_id(opp.getOrder_id());
				orderPayProgressDao.updateEnd(oopp);
			}else
				orderPayProgressDao.updateNotFirst(oopp);//不是第一次，只更新分期表即可
		}else{
			Orders no;
			if(o.getType()==2)
				no = new Orders(o.getId(), alipay_sn, 3, 1, new Date());//3是支付成功，1是受理中
			else
				no = new Orders(o.getId(), alipay_sn, 3, 5, new Date());//3是支付成功，5是全额支付
			ordersDao.update(no);
		}
	}
	
	//订单支付失败
	public void PayFail(String order_sn){
		Orders o = ordersDao.selectByOrderSn(order_sn);
		if(o==null){//分期
			OrderPayProgress opp = orderPayProgressDao.selectByProgressSn(order_sn);
			OrderPayProgress oopp = new OrderPayProgress(opp.getId(), 2);//支付失败
			orderPayProgressDao.updateNotFirst(oopp);
		}else{
			Orders no = new Orders(o.getId(), 2, new Date());//2是支付失败
			ordersDao.update(no);
		}
	}

}
