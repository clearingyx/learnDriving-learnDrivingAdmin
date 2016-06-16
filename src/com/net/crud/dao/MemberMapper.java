package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Member;
@Repository
public class MemberMapper {

    /*int insert(Member record);


    Member selectByPrimaryKey(Integer id);


    int update(Member record);*/
	@Autowired
	SqlSessionFactory factory;
	
	public List<Member> memberList(Map<String, Object> map){
		SqlSession session = factory.openSession();
		List<Member> list= session.selectList("Member.member_query",map);
		session.close();
		return list;
	}
	
	public Member memberDetail(Integer id){
		SqlSession session = factory.openSession();
		Member m= session.selectOne("Member.selectByPrimaryKey",id);
		session.close();
		return m;
	}
}