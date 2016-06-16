package com.net.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.net.util.JPushClientUtil;
import com.net.util.JSONUtil;

/**
 * @包名 com.itnoob.springmvc
 * @类名 TestJPushUtil
 * @作者 snail
 * @创建时间 2015-10-19
 * @描述 TODO
 */
public class TestJPushUtil {

    @Test
    public void TestJPushClientUtil() {
        String msgTitle = "推送测试";//推送标题
        String msgContent = "王涛看见请回复！";//推送内容
        String[] utels = { "13613477096", "13753837811" };//接收的别名，可以是发送一个，也可以是多个。
        for (String utel : utels) {
            Map<String, String> extrasMap = new HashMap<String, String>();
            extrasMap.put("content", JSONUtil.toJson(msgContent));//推送内容序列化并添加到hashmap中
            JPushClientUtil.pushMessage(msgTitle, msgContent, utel, extrasMap);//调用推送方法
        }
    }
}
