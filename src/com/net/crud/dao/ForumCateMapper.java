package com.net.crud.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.ForumCate;
@Repository
public class ForumCateMapper {

    /*int insert(ForumCate record);


    ForumCate selectByPrimaryKey(Integer id);


    int update(ForumCate record);*/
	@Autowired
	SqlSessionFactory factory;
	
	public List<ForumCate> forumCateList(){
		SqlSession session = factory.openSession();
		List<ForumCate> list = session.selectList("ForumCate.forumCateList");
		session.close();
		return list;
	}
	
	public int browseAdd(Integer id){
		SqlSession session = factory.openSession();
		int a= session.update("ForumCate.browseAdd",id);		
		session.close();
		return a;
	}
}