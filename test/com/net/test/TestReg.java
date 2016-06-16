package com.net.test;

import org.junit.Test;

/**
 * @包名 com.itnoob.springmvc
 * @类名 TestReg
 * @作者 snail
 * @创建时间 2015-5-11
 * @描述 TODO
 */
public class TestReg {

    @Test
    public void test() {
        String reg = "^(\\w+://)?\\w+(\\.\\w+)+.*$";
        String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
        String str = "http://yun.baidu.com";
        System.out.println(str.matches(reg));
        System.out.println(str.matches(regex));
    }
}
