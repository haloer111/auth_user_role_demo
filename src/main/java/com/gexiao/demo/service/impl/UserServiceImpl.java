package com.gexiao.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gexiao.demo.common.UserConstant;
import com.gexiao.demo.dao.UserMapper;
import com.gexiao.demo.entity.User;
import com.gexiao.demo.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * @Auther: gexiao
 * @Date: 2019/4/9 14:58
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    @Transactional
    public boolean save(User entity) {
        Optional.ofNullable(entity)
                .map(e -> {
                    //校验用户名
                    if (StringUtils.isBlank(e.getName()))
                        throw new RuntimeException("用户名不能为空");
                    if (getUserByName(e.getName()).isPresent())
                        throw new RuntimeException("已经有存在的用户名:" + e.getName());
                    return e;
                }).map(e -> {
                    //校验登录账号
                    if (StringUtils.isBlank(e.getLoginName()))
                        throw new RuntimeException("登录账号不能为空");
                    if (getUserByLoginName(e.getLoginName()).isPresent())
                        throw new RuntimeException("已经有存在的登录账号:" + e.getLoginName());
                    return e;
                }).map(e -> {
                    //密码加密
                    if (StringUtils.isBlank(e.getLoginPassword()))
                        throw new RuntimeException("登录密码不能为空");
                     e.setLoginPassword(new BCryptPasswordEncoder(UserConstant.PASSWORD_ENCODER_SALT).encode(e.getLoginPassword()));
                    return e;
                 }).map(e -> {
                    //设置更新时间
                    e.setUpdateTime(new Date());
                    return e;
                })
                .orElseThrow(() -> new RuntimeException("参数异常"));
        return super.save(entity);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return Optional.ofNullable(baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, name)));
    }

    @Override
    public Optional<User> getUserByLoginName(String loginName) {
        return Optional.ofNullable(baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getLoginName, loginName)));
    }

    @Override
    public String login(String loginName, String loginPassword) {
        User user = getUserByLoginName(loginName).orElseThrow(() -> new RuntimeException("查询不到该用户"));

        if(!new BCryptPasswordEncoder(UserConstant.PASSWORD_ENCODER_SALT).matches(loginPassword,user.getLoginPassword()))
            throw new RuntimeException("密码错误");

        //生成token

        return null;
    }
}