package com.net.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.net.demo.User;
import com.net.util.JSONUtil;

/**
 * @包名 com.itnoob.springmvc
 * @类名 TestJsonUtil
 * @作者 snail
 * @创建时间 2015-4-27
 * @描述 TODO
 */
public class TestJsonUtil {

    private static Logger log = Logger.getLogger(TestJsonUtil.class);

    @Test
    public void testJson() {
        User u = new User();
        String json = JSONUtil.toJson(u);
        log.info("扔进去对对象转出来是字符串"+json);
        
        log.info(JSONUtil.getStringFromJSONObject(json, "name"));
        
        log.info(JSONUtil.getJSONFromString(json));
        
        log.info(JSONUtil.prettyFormatJson(json));
        
        User user = JSONUtil.toBean(json, User.class);
        log.info(user);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("t1", "第一个");
        map.put("t2", "第二个");
        map.put("t3", "第三个");
        map.put("t4", "第四个");
        map.put("t5", "第五个");
        log.info(JSONUtil.toJson(map));
        
        Map<String,Object> m = JSONUtil.toMap(json);
        log.info(m);
        
        String jsonArray = "[{\"key2\":\"value2\",\"key1\":\"value1\"},{\"key2\":2,\"key1\":1},{\"shyx\":{\"age\":17,\"name\":\"shenyunxiao\"},\"wyp\":{\"age\":32,\"name\":\"wangyunpeng\"}}]";
        List<String> list = JSONUtil.toList(jsonArray,String.class);
        for(String s:list){
            System.out.println("s:"+s.toString());
        }
        
        String s = JSONUtil.toJson(list);
        log.info(s);
    }
}
