package com.net.crud.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Feedback;
import com.net.crud.modal.Version;
@Repository
public class FeedbackMapper {

	@Autowired
	 SqlSessionFactory factory;
	 
   public int insert(Feedback fb){
   	 SqlSession session = factory.openSession();
   	 int a= session.insert("Feedback.insert",fb);
   	 session.close();
   	 return a;
   }
   
}