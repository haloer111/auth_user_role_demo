package com.gexiao.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gexiao.demo.dao.RoleMapper;
import com.gexiao.demo.dao.UserRoleMapper;
import com.gexiao.demo.entity.Role;
import com.gexiao.demo.entity.UserRole;
import com.gexiao.demo.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: gexiao
 * @Date: 2019/4/10 15:12
 * @Description:
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {


    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<String> rolesByUserId(String userId) {
        //角色id
        List<String> roleIds = list(new LambdaQueryWrapper<UserRole>()
                                                .eq(UserRole::getUserId, userId))
                                                .stream()
                                                .map(UserRole::getRoleId)
                                                .collect(Collectors.toList());
        //角色名
        return roleMapper.selectList(new LambdaQueryWrapper<Role>()
                                                .in(Role::getId, roleIds))
                                                .stream()
                                                .map(Role::getName)
                                                .collect(Collectors.toList());
    }
}
