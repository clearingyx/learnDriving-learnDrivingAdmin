package com.net.demo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @包名 com.net.demo
 * @类名 SellerDao
 * @作者 snail
 * @创建时间 2015-10-22
 * @描述 TODO
 */
@Repository
public class SellerDao {

    @Autowired
    SqlSessionFactory factory;

    public List<Seller> getAllSellers() {
        SqlSession session = factory.openSession();
        List<Seller> sellers = session.selectList("SellerMapper.GetAllSellers", Seller.class);
        return sellers;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}
