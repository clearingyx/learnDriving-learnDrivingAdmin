package com.net.crud.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Version;
@Repository
public class VersionMapper {

	@Autowired
	 SqlSessionFactory factory;
	 
   public Version selectByNewVersion(){
   	 SqlSession session = factory.openSession();
   	Version v= session.selectOne("Version.selectByNewVersion");
   	session.close();
   	return v;
   }
   
}