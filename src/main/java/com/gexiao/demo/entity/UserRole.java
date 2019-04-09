package com.gexiao.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexiao.demo.entity.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: Administrator
 * @Date: 2019/4/9 14:43
 * @Description:
 */
@TableName(value = "sys_user_role")
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRole extends BaseEntity {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;
}
