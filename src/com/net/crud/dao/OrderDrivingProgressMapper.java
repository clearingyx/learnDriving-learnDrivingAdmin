package com.net.crud.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.OrderDrivingProgress;
@Repository
public class OrderDrivingProgressMapper {

    /*int insert(OrderDrivingProgress record);


    OrderDrivingProgress selectByPrimaryKey(Integer id);


    int update(OrderDrivingProgress record);*/
	@Autowired
	SqlSessionFactory factory;
	
	public Integer orderDrivingProgress(Integer order_id){
		SqlSession session = factory.openSession();
		Integer progress_name= session.selectOne("OrderDrivingProgress.selectByOid",order_id);
		session.close();
		return progress_name;
	}
}