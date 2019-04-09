package com.gexiao.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexiao.demo.entity.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: gexiao
 * @Date: 2019/4/9 14:43
 * @Description: 角色表
 */
@TableName(value = "sys_role")
@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends BaseEntity {
    /** 角色 */
    private String name ;
    /** 描述 */
    private String description ;
}
