package com.net.util;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

/**
 * @包名 com.net.util
 * @类名 PathUtil
 * @作者 snail
 * @创建时间 2015-8-12
 * @描述 TODO
 */
public class PathUtil {

    public static String GetAppRealPath (HttpServletRequest request){
        return request.getSession().getServletContext().getRealPath("/");
    } 
    public static String GetAppName (HttpServletRequest request){
        return request.getContextPath();
    }
    public static String getRootPath(HttpServletRequest request){
        String temp = GetAppRealPath(request);
        return temp.substring(0,temp.lastIndexOf("\\"));
    }
    /**
	 * 获取项目的根目录//如：/D:/jboss-4.2.2.GA/server/default/deploy/hp.war
	 */
	
   public static String AppPath = Thread.currentThread().getContextClassLoader().getResource(".").toString(); 
   /**
    * 得到的是 ClassPath的绝对URI路径
    */
   public static String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
   
    /**
     * @方法名 GetHttpPath
     * @方法描述 获取此WebApp的发布域名,展示图片路径前缀，其中domain的值在config.properties中配置
     * @返回类型 String 
     * @创建日期 2015-8-12
     */
    public static String GetHttp_Path() {
        return ResourceBundle.getBundle("config").getString("domain");
    }
}
