use test;

-- 用户表
drop table if exists `sys_user`;
create table sys_user
(
  id             varchar(64) primary key,
  name           varchar(64) unique key comment '用户名称',
  alias          varchar(64) comment '别名',
  tel            varchar(64) comment '手机号码',
  login_name     varchar(64) unique key comment '登录账号（唯一约束）',
  login_password varchar(64) comment '登录密码',
  create_time    datetime not null comment '创建时间',
  update_time    datetime not null comment '最近更新时间'
)
  engine = InnoDB
  default charset = utf8mb4
  comment = '用户表';

-- 角色表
drop table if exists `sys_role`;
create table `sys_role`
(
  id                   varchar(64) primary key ,
  name                 varchar(64) comment '角色',
  description          varchar(64) comment  '描述',
  create_time    datetime not null comment '创建时间',
  update_time    datetime not null comment '最近更新时间'
)
  engine = InnoDB
  default charset = utf8mb4
  comment = '角色表';
begin;
insert into test.`sys_role`
values ('1' , 'default','默认角色',now(),now());
commit ;


-- 权限资源表
drop table if exists `sys_authority`;
create table `sys_authority`
(
  id                   varchar(64) primary key ,
  url                  varchar(64) comment '资源路径（支持/*一级匹配、/**多级匹配）',
  http_method          varchar(64) comment '请求类型httpMethod',
  description          varchar(64) comment  '描述',
  ordered              int         comment '排序(数字越小越靠前)',
  create_time    datetime not null comment '创建时间',
  update_time    datetime not null comment '最近更新时间'
)
  engine = InnoDB
  default charset = utf8mb4
  comment = '权限资源表';

-- 用户角色关系表
drop table if exists `sys_user_role`;
create table `sys_user_role`
(
  id                   varchar(64) primary key ,
  user_id              varchar(64) comment '用户id',
  role_id              varchar(64) comment '角色id',
  create_time    datetime not null comment '创建时间',
  update_time    datetime not null comment '最近更新时间'
)
  engine = InnoDB
  default charset = utf8mb4
  comment = '用户角色关系表';

-- 角色权限资源关系表
drop table if exists `sys_role_auth`;
create table `sys_role_auth`
(
  id                   varchar(64) primary key ,
  role_id              varchar(64) comment '角色id',
  auth_id              varchar(64) comment '权限资源id',
  create_time    datetime not null comment '创建时间',
  update_time    datetime not null comment '最近更新时间'
)
  engine = InnoDB
  default charset = utf8mb4
  comment = '角色权限资源关系表';
