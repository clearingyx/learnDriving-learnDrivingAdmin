package com.net.crud.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Admin;
import com.net.crud.modal.ForumReply;
@Repository
public class AdminMapper {
	/* int insert(Admin record);
    Admin selectByPrimaryKey(Integer id);
    int update(Admin record);*/
	
	@Autowired
	SqlSessionFactory factory;
	
	/**
	 * 查询id等于1的adminName
	 */
	public Admin selectOne(){
		SqlSession session = factory.openSession();
		Integer id=1;
		Admin admin=session.selectOne("selectOne",id);
		session.close();
    	return admin;
    }
   
}