package com.net.demo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @包名 com.net.demo.UserDao
 * @类名 UserDao
 * @作者 snail
 * @创建时间 2015-4-28
 * @描述 有关User的所有数据库操作方法
 */
@Repository
public class UserDao {

    @Autowired
    SqlSessionFactory factory;

    public List<User> getAllUsers() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("UserMapper.GetAllUsers", User.class);
        session.close();
        return users;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}
