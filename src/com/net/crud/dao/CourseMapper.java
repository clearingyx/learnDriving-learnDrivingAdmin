package com.net.crud.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Course;
@Repository
public class CourseMapper {
	
   /* int insert(Course record);


    Course selectByPrimaryKey(Integer id);


    int update(Course record);*/
	@Autowired
	SqlSessionFactory factory;
	
	
    public  List<Course> courseList(Integer driving_id){
    	SqlSession session=factory.openSession();
    	List<Course> list = session.selectList("Course.selectByDrivingId",driving_id);
    	session.close();
    	return list;
    }
    
    public List<Course> courseList(List<Integer> list){
    	SqlSession session=factory.openSession();
    	List<Course> clist = session.selectList("Course.selectByList",list);
    	session.close();
    	return clist;
    }
}