package com.net.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @包名 com.net.demo.CommonController
 * @类名 CommonController
 * @作者 snail
 * @创建时间 2015-6-4
 * @描述 现有集成功能演示，注意事项及功能见各方法注释
 */
@Controller
public class DemoCommonController {

    @Autowired
    UserDao userDao;

    @Autowired
    SellerDao sellerDao;

    /**
     * @方法名 Alert
     * @方法描述 此例子是为了演示前台通过jQuery发送ajax请求后台，通过执行下面的方法完成你的业务之后，
     *       返回您先要返回的内容。可以是java的基础数据类型，可以是你自己建立的类的对象，
     *       但是前提一定要添加@ResponseBody。
     * @返回类型 String
     * @创建日期 2015-10-17
     */
    @RequestMapping("alert")
    @ResponseBody
    public String Alert() {
        return "哈哈";
    }

    /**
     * @方法名 Out
     * @方法描述 以下是为了直接在java方法中就输出到页面自己想返回的结果，一般为HTML代码。
     *       效果类似于PrintWriter对象的print方法，但由于PrintWriter是response对象的方法得到的，
     *       在没有设置返回类型时，也即是没有写response.setContentType()之前，中文会乱码
     *       且每次返回都需要参数中写PrintWriter的内置对象，略嫌麻烦，可以直接将先要返回页面的HTML代码返回，
     *       但是请求地址中需要配置produces的类型和编码格式，否则中文仍然乱码
     * @返回类型 String
     * @创建日期 2015-10-17
     */
    @RequestMapping(value = "out", produces = { "text/html;charset=utf-8" })
    @ResponseBody
    public String Out() {
        return "<script type='text/javascript'>alert('乱码');location.href='index'</script>";
    }

    /**
     * @方法名 index
     * @方法描述 springmvc.xml中配置了视图解析器，也配置了去查找jsp页面的路径，
     *       即/WEB-INF/pages/安全目录，但是仍然是可以返回到webroot根目录的jsp
     *       页面的，如下的index.jsp即在根目录，只要把对应的相对路径 关系理清楚就可以
     * @返回类型 String
     * @创建日期 2015-10-17
     */
    @RequestMapping("index")
    public String index() {
        return "../../index.jsp";
    }

    @RequestMapping("equals")
    public String SqlSessionFactory(Model model) {
        model.addAttribute("sellerFactory", sellerDao.getSqlSessionFactory());
        model.addAttribute("userFactory", userDao.getSqlSessionFactory());
        return "success.jsp";
    }
}
