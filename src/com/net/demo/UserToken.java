package com.net.demo;

/**
 * @包名 com.net.demo.UserToken
 * @类名 UserToken
 * @作者 snail
 * @创建时间 2015-4-29
 * @描述 通过枚举保证平台全局使用session的key值相同，比如用户的登录信息，
 *     保存session登录身份时写为session.setAttribute(UserToken.USER),
 *     读取的时候写为session.GetAttribute(UserToken.USER)
 */
public enum UserToken {

    USER("user");//保存用户登录session信息的key值

    private String value;

    private UserToken(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
