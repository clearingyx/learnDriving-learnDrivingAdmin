package com.net.crud.handlers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.CollectionRecord;
import com.net.crud.modal.Orders;
import com.net.crud.modal.SecondHand;

@Controller
public class SecondHandCarHandler extends BaseHandler{
	
	//二手车列表（筛选）
	@ResponseBody
	@RequestMapping("secondHandCarList")
	 public Object secondList(SecondHand sh,String condition ,String orderCondition,Float beginPrice,Float endPrice,
			 Integer beginAge,Integer endAge,Float beginMileage,Float endMileage,Float beginDisplacement ,Float endDisplacement,
			 Map<String, Object> map,Integer pageIndex,String type,Integer p_id){
		 sh.setUse_state(1);//二手车的筛选api包含品牌、车型、变速箱 、颜色、国标大于等于
		 map.put("begin", pageIndex);
		 map.put("end", pageSize); 
		 map.put("condition", condition);
		 map.put("orderCondition", orderCondition);//排序条件，price、age、mileage
		 map.put("beginPrice", beginPrice);//价格
		 map.put("endPrice", endPrice);
		 map.put("beginAge", beginAge);//车龄
		 map.put("endAge", endAge);
		 map.put("beginMileage", beginMileage);//里程
		 map.put("endMileage", endMileage);
		 map.put("beginDisplacement", beginDisplacement);//排量
		 map.put("endDisplacement", endDisplacement);
		 map.put("secondHand", sh);
		 map.put("p_id", p_id);
		 List<SecondHand> list =secondHandDao.SecondHandListForApi(map);
		 if("count".equals(type)) return list.size();
		 else return list;
	 }
	
	//收藏
	@ResponseBody
	@RequestMapping("SecondHandCarCollection")
	public Object SecondHandCarCollection(CollectionRecord cr){
		cr.setType(1);//1是二手车
		return result(collerctionRecordDao.insert(cr));
	}
	
	//预约
	@ResponseBody
	@RequestMapping("SecondHandCarAppointment")
	public Object SecondHandCarAppointment(Orders o){
		int a = ordersDao.selectJudgeTelRepeat(o.getTel());
		if(a==0){
			o.setDriving_state(1);//受理中
			o.setType(3);//二手车
			a = ordersDao.insert(o);
			if(a>0) return "success";
			else return "fail";
		}else{
			return "warning";
		}
	}
	
	@ResponseBody
	@RequestMapping("second_hand_detail")
	public Object second_hand_detail(Integer id){
		return secondHandDao.selectByPrimaryKey(id);
	}
}
