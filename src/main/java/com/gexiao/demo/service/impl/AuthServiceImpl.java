package com.gexiao.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gexiao.demo.dao.AuthMapper;
import com.gexiao.demo.entity.Authority;
import com.gexiao.demo.service.IAuthService;
import org.springframework.stereotype.Service;

/**
 * @Auther: gexiao
 * @Date: 2019/4/11 14:28
 * @Description:
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper,Authority> implements IAuthService {
}
