package com.net.pay.alipay.config;

/* *
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * 版本：3.3
 * 日期：2012-08-10
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 * 提示：如何获取安全校验码和合作身份者ID
 * 1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 * 2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 * 3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”
 * 安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 * 解决方法：
 * 1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 * 2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = "2088121635966382";

    //商户支付宝账号
    public static String seller_email = "pay@rendezhixin.com";
    
    //商户真实姓名
    public static String account_name = "北京仁德智信科技有限公司";
    
    // 商户的私钥
    public static String private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJ1lsDNJwHIDF28FGid0S/UXwEoS7NjIujKxNLgcbNTU7MP+xURaNoalRf2s7koj7gxJlgUgFQFDcCV7oB4xN3nX6t9JYMDl+LCf7r1GVnQpm2f/OaRI3Sl6rqDIoJ7yDOv+zWF5RmVLO2ZEaUMJkUI2T15MLYY45G8YLlQgBjd/AgMBAAECgYEAjUNNz8o6iVkS+BYpMg3jejZ140V3At2sl4CJo1AHsUDkusd2vvEEjPXaimFhgHMc3DRTC4iOsZKYHVwGCfL8KNtS5LPEeAc41LlcaCqdVSeDNMhisFNETtMinnqCkYd8TSxOHj3rdEwTrh9XYmek7t4QlHBySQIXmSEurJjSEgECQQDOrtaFA+JQQeKqpamq1dmnBnb8FivCWls1hCOYHtZ3acn+7r6gxRgQp7wYDkjWlubl0J0u7iJjWZkcATprEjR/AkEAwvQ/KN7ZNyNxgmVzluHiM9IEOIxheKeb0x6rdWZeGngByz6L0CDPONg9QGrdTclwRnlfZ3pXIwHEToygXa59AQJBAII4zpiIVfNTT8lND5W/n58JB7bVEUUnQQh69SJHa8FZOhgRvLH2/K6hwHU3qtTpxxlNU3vaNnh6X2mxrGkB02kCQQCMqyBHpUSmfHSS2hEldad6LLfO9bv/CzFsjFy7QTn1b1IcDO1lJ8deBOltaa51SjwxHbKxP51QLR4wb1fnQNgBAkBD3aC3XTyI8dHRjJFX2NblnGR3NYP3dxLuzU+47h1Z7vFRAm35fNjv7Jh8m27ZbIuhbksTImRf4AhKoj9ldgH7";
    // 支付宝的公钥，无需修改该值
    public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    //商户安全校验码
    public static String key = "rnhcvdcd4oyi6zvjmmt15euzzjy25600";
    
    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    // 调试用，创建TXT日志文件夹路径
    public static String log_path = "D:\\";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "utf-8";

    // 签名方式 不需修改(支付回调签名方式)
    public static String pay_sign_type = "RSA";

    // 签名方式 不需修改(退款签名方式)
    public static String sign_type = "MD5";

}
