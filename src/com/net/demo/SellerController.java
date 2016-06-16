package com.net.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @包名 com.net.demo
 * @类名 SellerController
 * @作者 snail
 * @创建时间 2015-10-22
 * @描述 TODO
 */
@Controller
public class SellerController {

    @Autowired
    private SellerDao sellerDao;

    @RequestMapping("SellerList")
    public String getAllSellers() {
        System.err.println(sellerDao.getAllSellers());
        return "success.jsp";
    }

}
