package com.net.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.net.demo.SellerDao;
import com.net.demo.User;
import com.net.demo.UserDao;

/**
 * @包名 com.itnoob.springmvc
 * @类名 TestDruidConn
 * @作者 snail
 * @创建时间 2015-4-28
 * @描述 TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc.xml")
public class TestDruidConn extends AbstractJUnit4SpringContextTests {

    @Autowired
    public UserDao userDao;

    @Autowired
    public SellerDao sellerDao;

    @Test
    public void testUserDao() {
        System.err.println(userDao.getAllUsers());
        System.err.println(userDao.getSqlSessionFactory().equals(sellerDao.getSqlSessionFactory()));
        System.err.println("userDao-->sqlsessionfactory" + userDao.getSqlSessionFactory());
        System.err.println("sellerDao-->sqlsessionfactory" + sellerDao.getSqlSessionFactory());
    }

}
