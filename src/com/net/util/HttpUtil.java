package com.net.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpUtil {

    private static Logger log = Logger.getLogger(HttpUtil.class);

    /**
     * 得到请求的IP地址
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("Host");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isBlank(ip)) {
            ip = "0.0.0.0";
        }
        return ip;
    }

    /**
     * 得到请求的根目录
     * @param request
     * @return
     */
    public static String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        return basePath;
    }

    /**
     * @方法名 post
     * @方法描述 发送无参数名post请求
     * @返回类型 String
     * @创建日期 2015-3-24
     */
    public static String post(String xmlParam, String url) { // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost    
        HttpPost httppost = new HttpPost(url);
        String result = null;
        try {
            httppost.setEntity(new StringEntity(xmlParam, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, "UTF-8");
                    log.info(result);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源    
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @方法名 post
     * @方法描述 将参数名，参数保存为map中的key和value：发送post请求
     * @返回类型 String
     * @创建日期 2015-3-24
     */
    public static String post(Map<String, Object> map, String url) throws ClientProtocolException, IOException {
        // 创建一个默认的HttpClient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String view = "";
        try {
            HttpPost httppost = new HttpPost(url);
            // 添加HTTP POST参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();

            for (Map.Entry<String, Object> m : map.entrySet()) {
                log.info("本次请求的key:" + m.getKey() + " value:" + m.getValue());
                nvps.add(new BasicNameValuePair(m.getKey(), m.getValue().toString()));
            }

            // 将POST参数以UTF-8编码并包装成表单实体对象
            httppost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            // 打印请求地址
            log.info("请求的URL地址为：" + httppost.getRequestLine().getUri());
            // 执行请求并获取结果
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    view = EntityUtils.toString(entity, "UTF-8");
                    log.info("请求返回值：" + view);
                }
            } finally {
                response.close();
            }
        } finally {
            // 当不再需要HttpClient实例时,关闭连接管理器以确保释放所有占用的系统资源
            httpclient.close();
        }
        return view;
    }
}
