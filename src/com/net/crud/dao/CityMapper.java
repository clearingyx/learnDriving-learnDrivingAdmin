package com.net.crud.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Ad;
import com.net.crud.modal.City;

@Repository
public class CityMapper {
	@Autowired
	 SqlSessionFactory factory;
	
	public List<City> selectQuery(){
		SqlSession session = factory.openSession();
		List<City> list = session.selectList("City.selectQuery");
		session.close();
		return list;
	}
}