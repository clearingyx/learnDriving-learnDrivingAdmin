package com.net.crud.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.handlers.OrdersHandler;
import com.net.crud.modal.OrderPayProgress;
import com.net.crud.modal.Orders;
@Repository
public class OrderPayProgressMapper {

    /*int insert(OrderPayProgress record);


    OrderPayProgress selectByPrimaryKey(Integer id);


    int update(OrderPayProgress record);*/
	private static Logger log = Logger.getLogger(OrderPayProgressMapper.class);
	@Autowired
	SqlSessionFactory factory;
	
	public List<OrderPayProgress> orderPayProgress(Integer order_id){
		SqlSession session = factory.openSession();
		List<OrderPayProgress> list= session.selectList("OrderPayProgress.selectByOid",order_id);
		session.close();
		return list;
	}
	
	public OrderPayProgress selectByAliPaySn(String alipay_sn){
		SqlSession session = factory.openSession();
		OrderPayProgress o= session.selectOne("OrderPayProgress.selectByAliPaySn",alipay_sn);
		session.close();
		return o;
	}
	public OrderPayProgress selectByProgressSn(String progress_sn){
		SqlSession session = factory.openSession();
		OrderPayProgress o = session.selectOne("OrderPayProgress.selectByProgressSn",progress_sn);
		session.close();
		return o;
	}
	
	public int updateFirst(OrderPayProgress o){
		SqlSession session = factory.openSession(false);
		int a = 0;
		if(session.update("OrderPayProgress.update",o)>0){
			Orders order = new Orders(o.getOrder_id(), 4);//4是受理成功
			a = session.update("Orders.update",order);
			if(a>0){
				session.commit();
				session.close();
			}else log.error("更新分期表成功，更新订单表状态失败！");
		}else log.error("更新分期表状态失败！");
		return a;
	}
	
	public int updateNotFirst(OrderPayProgress o){
		SqlSession session = factory.openSession();
		int a= session.update("OrderPayProgress.update",o);
		session.close();
		return a;
	}
	
	public int updateEnd(OrderPayProgress o){
		SqlSession session = factory.openSession(false);
		int a = 0;
		if(session.update("OrderPayProgress.update",o)>0){
			Orders order = new Orders(o.getOrder_id(), 7);//7是分期完成
			a = session.update("Orders.update",order);
			if(a>0){
				session.commit();
				session.close();
			}else log.error("更新分期表成功，更新订单表状态失败！");
		}else log.error("更新分期表状态失败！");
		return a;
	}
}