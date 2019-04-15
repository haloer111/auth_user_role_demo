package com.gexiao.demo.common;

/**
 * @Auther: gexiao
 * @Date: 2019/4/9 16:12
 * @Description:
 */
public interface UserConstant {
    int PASSWORD_ENCODER_SALT = 7;

    /**
     * jwt存储用户ID的key
     */
     String USER_ID = "userId";

    /**
     * jwt存储用户名的key
     */
     String NAME = "name";
}
