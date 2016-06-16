package com.net.test;

import org.junit.Test;

import com.net.util.SendMsg_webchinese;

/**
 * @包名 com.itnoob.springmvc
 * @类名 TestMsg
 * @作者 snail
 * @创建时间 2015-4-27
 * @描述 TODO
 */
public class TestMsg {

    /**
     * @方法名 test
     * @方法描述 测试的时候，内容填写真实运营性信息，否则容易通不过审核
     * @返回类型 void 
     * @创建日期 2015-4-27
     */
    @Test
    public void test() throws Exception {
        System.out.println(SendMsg_webchinese.sendmsg("1873458563", "尊敬的用户：4月会员日劲爆来袭！精选生鲜美食、酒水饮品，购物享双倍购物积分！300积分抽满200减30优惠券。仅3天！"));   
    }
}
