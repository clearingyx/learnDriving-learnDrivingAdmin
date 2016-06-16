package com.net.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @包名 com.itnoob.springmvc.util
 * @类名 SendMsg_webchinese
 * @作者 snail
 * @创建时间 2015-4-27
 * @描述 TODO
 */
public class SendMsg_webchinese {

    private static ResourceBundle resb = ResourceBundle.getBundle("config");

    private static String uid = resb.getString("uid");

    private static String key = resb.getString("key");

    /**
     * 错误对照码:
     * -1 没有该用户账户——请检查sms-config.properties中uid是否写错，
     * 若有中文需要转换为ASCII码，转换工具为ASCIIAndCNStr.java
     * -2 接口密钥不正确--同上
     * -21 MD5接口密钥加密不正确
     * -3 短信数量不足
     * -11 该用户被禁用
     * -14 短信内容出现非法字符
     * -4 手机号格式不正确
     * -41 手机号码为空
     * -42 短信内容为空
     * -51 短信签名格式不正确
     * -6 IP限制
     * 大于0 短信发送数量
     */
    static int[] status = { -51, -42, -41, -21, -14, -11, -6, -4, -2, -1 };

    /**
     * @方法名 sendmsg
     * @方法描述 发送短信方法——所需参数分别为smsMob-接收手机号，content-短信内容
     * @返回类型 boolean true为发送成功，false为发送失败
     * @创建日期 2015-4-27
     */
    public static boolean sendmsg(String smsMob, String content) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Uid", uid);
        map.put("Key", key);
        map.put("smsMob", smsMob);
        map.put("smsText", content);
        String result = HttpUtil.post(map, "http://utf8.sms.webchinese.cn/");
        switch (Integer.parseInt(result)) {
        case -1:
            System.err.println("错误：没有该用户账户");
            break;
        case -2:
            System.err.println("错误：接口密钥不正确");
            break;
        case -21:
            System.err.println("错误：MD5接口密钥加密不正确");
            break;
        case -3:
            System.err.println("错误：短信数量不足");
            break;
        case -11:
            System.err.println("错误：该短信商户被禁用");
            break;
        case -14:
            System.err.println("错误：短信内容出现非法字符");
            break;
        case -4:
            System.err.println("错误：手机号格式不正确");
            break;
        case -41:
            System.err.println("错误：手机号码为空");
            break;
        case -42:
            System.err.println("错误：短信内容为空");
            break;
        case -51:
            System.err.println("错误：短信签名格式不正确");
            break;
        case -6:
            System.err.println("错误：IP限制");
            break;
        default:
            System.err.println("短信发送成功：发送条数为" + result);
            break;
        }
        int temp = Arrays.binarySearch(status, Integer.parseInt(result));
        return temp < 0 ? true : false;
    }
}
