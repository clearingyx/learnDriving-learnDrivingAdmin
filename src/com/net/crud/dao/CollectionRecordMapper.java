package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.SecondHand;
import com.net.crud.modal.CollectionRecord;
@Repository
public class CollectionRecordMapper {

   /* int insert(collectionRecord record);


    collectionRecord selectByPrimaryKey(Integer id);


    int update(collectionRecord record);*/
	@Autowired
	 SqlSessionFactory factory;
	 
   public int insert(CollectionRecord cr){
   	 SqlSession session = factory.openSession();
   	 int a= session.insert("CollectionRecord.insert",cr);
   	 session.close();
   	 return a;
   }
   
   public int delete(Integer id){
	   SqlSession session = factory.openSession();
	   int a= session.delete("CollectionRecord.delete",id);
	   session.close();
	   return a;
   }
}