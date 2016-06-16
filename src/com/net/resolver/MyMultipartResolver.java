package com.net.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @包名 com.net.resolver
 * @类名 MyMultipartResolver
 * @作者 snail
 * @创建时间 2015-6-30
 * @描述 自定义上传拦截器，处理ckeditor中使用最原始方法上传图片和spring的带文件上传的表单配置冲突
 */
public class MyMultipartResolver extends CommonsMultipartResolver {

    private String[] excludeUrls;

    
    public String[] getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(String[] excludeUrls) {
        this.excludeUrls = excludeUrls;
    }


    /**
     * 这里是处理Multipart http的方法。如果这个返回值为true,那么Multipart http body就会MyMultipartResolver 消耗掉.如果这里返回false
     * 那么就会交给后面的自己写的处理函数处理例如刚才ServletFileUpload 所在的函数
     * @see org.springframework.web.multipart.commons.CommonsMultipartResolver#isMultipart(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public boolean isMultipart(HttpServletRequest request) {
        // 这里可以自己换判断 
        for(String excludeUrl:excludeUrls){
            if (request.getRequestURI().contains(excludeUrl)) {
                return false;
            }    
        }
        return super.isMultipart(request);
    }

}
