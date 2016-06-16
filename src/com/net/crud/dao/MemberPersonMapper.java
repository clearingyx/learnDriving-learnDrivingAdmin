package com.net.crud.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.MemberPerson;
@Repository
public class MemberPersonMapper {

    /*int insert(MemberPerson record);


    MemberPerson selectByPrimaryKey(Integer id);


    int update(MemberPerson record);*/
	@Autowired
	SqlSessionFactory factory;
	
	public List<MemberPerson> memberPersonList(Integer member_id){
		SqlSession session = factory.openSession();
		List<MemberPerson> list= session.selectList("MemberPerson.memberPersonList",member_id);
		session.close();
		return list;
	}
	
	public int judgeAppointmentRepeat(MemberPerson mp){
		SqlSession session = factory.openSession();
		int a= session.selectOne("MemberPerson.judgeRepeat",mp);	
		session.close();
		return a;
	}
	
	public int insert(MemberPerson mp){
		SqlSession session = factory.openSession();
		int a= session.insert("MemberPerson.insert",mp);
		session.close();
		return a;
	}
}