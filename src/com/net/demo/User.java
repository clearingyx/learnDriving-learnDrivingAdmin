package com.net.demo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author snail
 * @Description 用户/买家实体类
 * @date 2014-11-12 下午04:25:48
 */
public class User implements Serializable {

    /**
     * @变量名 serialVersionUID : TODO(用一句话描述次变量作用)
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields name : 用户名
     */
    private String name;

    /**
     * @Fields password : 登录密码
     */
    private String password;

    /**
     * @Fields registerdate : 用户注册日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    //不添加此注解会导致序列化的date类型变为long类型
    private Date registerdate;

    /**
     * @Fields uid : 用户ID编号
     */
    private int uid;

    /**
     * <p>
     * 方法描述:
     * </p>
     */
    public User() {
        super();
    }

    /**
     * <p>
     * 方法描述:
     * </p>
     * @param registerdate
     * @param uid
     * @param password
     * @param name
     */
    public User(Date registerdate, int uid, String password, String name) {
        super();
        this.registerdate = registerdate;
        this.uid = uid;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public int getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", registerdate=" + registerdate
                + ", uid=" + uid + "]";
    }

}
