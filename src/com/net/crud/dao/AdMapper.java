package com.net.crud.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Ad;

@Repository
public class AdMapper {
	@Autowired
	 SqlSessionFactory factory;
	
	public List<Ad> selectQuery(){
		SqlSession session = factory.openSession();
		List<Ad>list = session.selectList("Ad.selectQuery");
		session.close();
		return list;
	}
}