package com.gexiao.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexiao.demo.entity.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: gexiao
 * @Date: 2019/4/9 14:43
 * @Description: 角色资源表
 */
@TableName(value = "sys_role_auth")
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleAuth extends BaseEntity {
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 权限资源id
     */
    private String authId;
}
