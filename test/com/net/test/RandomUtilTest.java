package com.net.test;

import org.junit.Test;

import com.net.util.RandomUtil;
import com.net.util.UUIDHashCode;


/**
 * @包名 com.itnoob.springmvc
 * @类名 RandomuTitlTest
 * @作者 snail
 * @创建时间 2015-4-27
 * @描述 TODO 
 */
public class RandomUtilTest {
    @Test
    public void testRandomUtil(){
        System.out.println(RandomUtil.getRandom(12));
    }
    @Test
    public void testUUIDHashCode(){
        String orderIdByUUId = UUIDHashCode.getOrderIdByUUId();
        System.out.println(orderIdByUUId);
    }
    
}
