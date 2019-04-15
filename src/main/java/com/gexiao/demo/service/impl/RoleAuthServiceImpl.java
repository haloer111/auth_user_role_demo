package com.gexiao.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gexiao.demo.dao.RoleAuthMapper;
import com.gexiao.demo.entity.RoleAuth;
import com.gexiao.demo.service.IRoleAuthService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: gexiao
 * @Date: 2019/4/11 15:42
 * @Description:
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthMapper, RoleAuth> implements IRoleAuthService {
    @Override
    public List<RoleAuth> listByRoleId(String roleId) {
        List<RoleAuth> list = list(new LambdaQueryWrapper<RoleAuth>().eq(RoleAuth::getRoleId, roleId));
        return list;
    }
}
