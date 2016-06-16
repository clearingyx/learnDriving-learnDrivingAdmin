package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Notice;
@Repository
public class NoticeMapper {

   /* int insert(Notice record);
    Notice selectByPrimaryKey(Integer id);
    int update(Notice record);*/
	@Autowired
	 SqlSessionFactory factory;
	 
	 public List<Notice> noticeListByPid(Map<String, Object> map){
		 SqlSession session = factory.openSession();
		 List<Notice> list= session.selectList("Notice.noticeListByPid",map);
	 	session.close();
	 	return list;
	 }
	 
	 public int update(Notice n){
		 SqlSession session = factory.openSession();
		 int a= session.update("Notice.update",n);
		 session.close();
		 return a;
	 }
	 
	 public int delete(Notice n){
		 SqlSession session = factory.openSession();
		 int a= session.delete("Notice.delete",n);
		 session.close();
		 return a;
	 }
}