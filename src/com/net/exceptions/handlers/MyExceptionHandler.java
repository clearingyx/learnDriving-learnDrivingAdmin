package com.net.exceptions.handlers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @包名 com.itnoob.springmvc.exceptions.handlers
 * @类名 MyExceptionHandler
 * @作者 snail
 * @创建时间 2015-4-10
 * @描述 自定义异常处理,平台所有异常均向外抛出，在此处处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    private static Logger log = Logger.getLogger(MyExceptionHandler.class);

    @ExceptionHandler( { Exception.class })
    public ModelAndView handleArithmeticException(Exception ex) {
        log.error("exception : " + ex);
        ModelAndView mv = new ModelAndView("error.jsp");
        mv.addObject("exception", ex);
        return mv;
    }
}
