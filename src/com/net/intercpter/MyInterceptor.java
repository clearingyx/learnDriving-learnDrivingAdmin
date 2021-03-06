package com.net.intercpter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.net.demo.UserToken;
import com.net.util.BeanUtil;

/**
 * 常见应用场景
 * 1、日志记录：记录请求信息的日志，以便进行信息监控、信息统计、计算PV（Page View）等。
 * 2、权限检查：如登录检测，进入处理器检测检测是否登录，如果没有直接返回到登录页面；
 * 3、性能监控：有时候系统在某段时间莫名其妙的慢，可以通过拦截器在进入处理器之前记录开始时间，在处理完后记录结束时间，从而得到该请求的处理时间（如果有反向代理，如apache可以自动记录）；
 * 4、通用行为：读取cookie得到用户信息并将用户对象放入请求，从而方便后续流程使用，还有如提取Locale、Theme信息等，只要是多个处理器都需要的即可使用拦截器实现。
 * 5、OpenSessionInView：如Hibernate，在进入处理器打开Session，在完成后关闭Session。
 * …………本质也是AOP（面向切面编程），也就是说符合横切关注点的所有功能都可以放入拦截器实现。
 */

/**
 * @包名 com.net.intercpter.MyInterceptor
 * @类名 HandlerInterceptor
 * @作者 snail
 * @创建时间 2015-4-10
 * @描述 自定义拦截器，其中需要实现接口的方法。MyEclipse8.5默认选择的jdk编译环境为1.5，实现
 *     接口方法不属于重写，故而自动添加实现的方法不会出现@Override注解.而这个bug在1.6得已
 *     改善，认为不管是覆盖父类的方法还是实现接口的方法，都属于方法的重写。
 */
public class MyInterceptor implements HandlerInterceptor {

    private static Logger log = Logger.getLogger(MyInterceptor.class);

    /*
     * (非 JavaDoc)
     * <p>方法名:afterCompletion</p>
     * <p>描述:</p>
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object arg2, Exception arg3) throws Exception {
    //        log.info("afterCompletion:执行结束");
    }

    /*
     * (非 JavaDoc)
     * <p>方法名:postHandle</p>
     * <p>描述:</p>
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2,
            ModelAndView arg3) throws Exception {
    //        log.info("postHandle:执行结束");
    }

    /**
     * 登录身份验证在此处处理，判断session是否失效也是此处处理。以下内容仅为参考，后续可根据自己业务进行修改拓展
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2)
            throws Exception {
        //        log.info("preHandle:执行结束");
        Object obj = request.getSession().getAttribute(UserToken.USER.getValue());
        if (BeanUtil.nonNull(obj)) {
            //可以再此做权限认证，从而进行不同到页面跳转
            return true;
        } else {
            //            response.sendRedirect("login.jsp");
            return true;
        }

    }
}
