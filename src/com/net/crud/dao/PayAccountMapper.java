package com.net.crud.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.PayAccount;
import com.net.crud.modal.Person;
@Repository
public class PayAccountMapper {
	@Autowired
	 SqlSessionFactory factory;

   /* int insert(PayAccount record);


    PayAccount selectByPrimaryKey(Integer id);


    int update(PayAccount record);*/
	
	 public PayAccount selectByPid(Integer p_id){
    	 SqlSession session = factory.openSession();
    	 PayAccount p= session.selectOne("PayAccount.selectByPid", p_id);
    	 session.close();
    	 return p;
    }
}