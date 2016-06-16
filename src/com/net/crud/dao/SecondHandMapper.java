package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Driving;
import com.net.crud.modal.SecondHand;
@Repository
public class SecondHandMapper {
    /*int insert(SecondHand record);
    
    int update(SecondHand record);*/
	
	 @Autowired
	 SqlSessionFactory factory;
	
	 public SecondHand selectByPrimaryKey(Integer id){
		 SqlSession session = factory.openSession();
		 SecondHand s= session.selectOne("SecondHand.selectByPrimaryKey",id);
		 session.close();
		 return s;
	 }
	 
    public List<SecondHand> SecondHandListForApi(Map<String, Object> map){
    	 SqlSession session = factory.openSession();
    	 List<SecondHand> list= session.selectList("SecondHand.selectListForApi",map);
    	 session.close();
    	 return list;
    }
    
    public List<SecondHand> CollectionRecordSecondList(Map<String, Object> map){
    	 SqlSession session = factory.openSession();
    	 List<SecondHand> list=  session.selectList("SecondHand.CollectionRecordSecondList",map);
    	 session.close();
    	 return list;
    }
}