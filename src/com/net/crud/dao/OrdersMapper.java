package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.OrderDrivingProgress;
import com.net.crud.modal.OrderPayProgress;
import com.net.crud.modal.Orders;
@Repository
public class OrdersMapper {
	private static Logger log = Logger.getLogger(OrdersMapper.class);
	@Autowired
	SqlSessionFactory factory;
	
	public int selectJudgeTelRepeat(String tel){
		SqlSession session = factory.openSession();
		int a = session.selectOne("Orders.selectJudgeTelRepeat",tel);
		session.close();
		return a;
	}
	
	public int insert(Orders orders){
		SqlSession session = factory.openSession();
		int a = session.insert("Orders.insert",orders);
		session.close();
		return a;
	}
	public int update(Orders orders){
		SqlSession session = factory.openSession();
		int a= session.update("Orders.update",orders);
		session.close();
		return a;
	}
	
	public List<Orders> OrderListByPid(Map<String , Object> map){
		SqlSession session = factory.openSession();
		List<Orders> list = session.selectList("Orders.selectByPrimaryKey",map);
		session.close();
		return list;
	}
	
	public Orders selectByAliPaySn(String alipay_sn){
		SqlSession session = factory.openSession();
		Orders o = session.selectOne("Orders.selectByAliPaySn",alipay_sn);
		session.close();
		return o;
	}
	public Orders selectByOrderSn(String order_sn){
		SqlSession session = factory.openSession();
		Orders o = session.selectOne("Orders.selectByOrderSn",order_sn);
		session.close();
		return o;
	}
	public int selectByOrderRepeat(Orders o){
		SqlSession session = factory.openSession();
		int a = session.selectOne("Orders.selectByOrderRepeat",o);
		session.close();
		return a;
	}
}