package com.net.demo;

import java.io.Serializable;

/**
 * @包名 com.net.demo
 * @类名 Seller
 * @作者 snail
 * @创建时间 2015-10-22
 * @描述 TODO
 */
public class Seller implements Serializable {

    /**
     * @变量名 serialVersionUID : TODO(用一句话描述次变量作用)
     */
    private static final long serialVersionUID = 1L;

    private int sid;

    private String name;

    private String city;

    private int age;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Seller [age=" + age + ", city=" + city + ", name=" + name + ", sid=" + sid + "]";
    }

}
