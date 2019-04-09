package com.gexiao.demo.controller;

import com.alibaba.fastjson.JSON;
import com.gexiao.demo.common.Result;
import com.gexiao.demo.entity.User;
import com.gexiao.demo.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteDateUseDateFormat;

/**
 * @Auther: gexiao
 * @Date: 2019/4/9 15:23
 * @Description:
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<IUserService, User> {


    @PostMapping("login")
    public Result login(@RequestBody Map<String, String> body) {
        return Result.ok(service.login(body.get("loginName"), body.get("loginPass")));
    }


    public static void main(String[] args) {
        User e = new User();
        e.setName("");
        e.setAlias("");
        e.setTel("");
        e.setLoginName("");
        e.setLoginPassword("");
        e.setCreateAndUpdateTime();
        e.setId("");
        e.setCreateTime(new Date());
        e.setUpdateTime(new Date());

        System.out.println(JSON.toJSONString(e, PrettyFormat, WriteDateUseDateFormat));
    }
}
