package com.net.crud.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Person;

@Repository
public class PersonMapper {
	 @Autowired
	 SqlSessionFactory factory;
	 
    public int insert(Person p){
    	 SqlSession session = factory.openSession();
    	 int a = session.insert("Person.insert",p);
    	 return a;
    }
    //用户头像上传api用
    public int personEditPhoto(Map<String, Object> map){
    	 SqlSession session = factory.openSession();
    	 int a = session.update("Person.updateByPhoto",map);
    	 return a;
    }
    /*Person selectByPrimaryKey(Integer id);*/
    
    public Person selectByLogin(Person person){
    	 SqlSession session = factory.openSession();
    	 Person p = session.selectOne("Person.selectByLogin", person);
    	 return p;
    }
    
    public List<Person> sparringQuery(Map<String, Object> map){
    	SqlSession session = factory.openSession();
    	List<Person> list= session.selectList("Person.sparringQuery",map);
    	session.close();
    	return list;
    }
    public List<Person> personQueryByCoach(Map<String, Object> map){
    	SqlSession session = factory.openSession();
    	List<Person> list= session.selectList("Person.personQueryByCoach",map);
    	session.close();
    	return list;
    }
    public int personJudgeTelRepeat(String tel){
    	SqlSession session = factory.openSession();
    	int a = session.selectOne("Person.personJudgeTelRepeat",tel);
    	return a;
    }
    public int update(Person person){
    	SqlSession session = factory.openSession();
    	int a = session.update("Person.update",person);
    	return a;
    }
    public int updatePwd(Person person){
    	SqlSession session = factory.openSession();
    	int a = session.update("Person.updatePwd",person);
    	return a;
    }
    public int judgePwd(Person p){
    	SqlSession session = factory.openSession();
    	int a = session.selectOne("Person.judgePwd",p);
    	return a;
    }
    //课程的教练列表
    public List<Person>  coachListByCourse(Integer id){
    	SqlSession session = factory.openSession();
    	String data = id+"_";
    	List<Person> list = session.selectList("Person.coachListByCourse",data);
    	return list;
    }
    
    //判断电话号码是否存在
    public int judgeTel(String tel){
    	SqlSession session = factory.openSession();
    	int a = session.selectOne("Person.judgeTel",tel);
    	return a;
    }
    
    public Person personById(Integer id){
    	SqlSession session = factory.openSession();
    	Person p = session.selectOne("Person.personById",id);
    	return p;
    }
}