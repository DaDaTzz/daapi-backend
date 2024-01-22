#
数据库初始化
#
#

-- 创建库
create
database if not exists api;

-- 切换库
use
api;

-- 用户表
create table if not exists user
(
    id
    bigint
    auto_increment
    comment
    'id'
    primary
    key,
    userAccount
    varchar
(
    256
) not null comment '账号',
    access_key varchar
(
    256
) comment 'access_key',
    secret_key varchar
(
    256
) comment 'secret_key',
    userAccount varchar
(
    256
) not null comment '账号',
    userPassword varchar
(
    512
) not null comment '密码',
    unionId varchar
(
    256
) null comment '微信开放平台id',
    mpOpenId varchar
(
    256
) null comment '公众号openId',
    userName varchar
(
    256
) null comment '用户昵称',
    userAvatar varchar
(
    1024
) null comment '用户头像',
    userProfile varchar
(
    512
) null comment '用户简介',
    userRole varchar
(
    256
) default 'user' not null comment '用户角色：user/admin/ban',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete tinyint default 0 not null comment '是否删除',
    index idx_unionId
(
    unionId
)
    ) comment '用户' collate = utf8mb4_unicode_ci;

-- 帖子表
create table if not exists post
(
    id
    bigint
    auto_increment
    comment
    'id'
    primary
    key,
    title
    varchar
(
    512
) null comment '标题',
    content text null comment '内容',
    tags varchar
(
    1024
) null comment '标签列表（json 数组）',
    thumbNum int default 0 not null comment '点赞数',
    favourNum int default 0 not null comment '收藏数',
    userId bigint not null comment '创建用户 id',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete tinyint default 0 not null comment '是否删除',
    index idx_userId
(
    userId
)
    ) comment '帖子' collate = utf8mb4_unicode_ci;

-- 帖子点赞表（硬删除）
create table if not exists post_thumb
(
    id
    bigint
    auto_increment
    comment
    'id'
    primary
    key,
    postId
    bigint
    not
    null
    comment
    '帖子 id',
    userId
    bigint
    not
    null
    comment
    '创建用户 id',
    createTime
    datetime
    default
    CURRENT_TIMESTAMP
    not
    null
    comment
    '创建时间',
    updateTime
    datetime
    default
    CURRENT_TIMESTAMP
    not
    null
    on
    update
    CURRENT_TIMESTAMP
    comment
    '更新时间',
    index
    idx_postId
(
    postId
),
    index idx_userId
(
    userId
)
    ) comment '帖子点赞';

-- 帖子收藏表（硬删除）
create table if not exists post_favour
(
    id
    bigint
    auto_increment
    comment
    'id'
    primary
    key,
    postId
    bigint
    not
    null
    comment
    '帖子 id',
    userId
    bigint
    not
    null
    comment
    '创建用户 id',
    createTime
    datetime
    default
    CURRENT_TIMESTAMP
    not
    null
    comment
    '创建时间',
    updateTime
    datetime
    default
    CURRENT_TIMESTAMP
    not
    null
    on
    update
    CURRENT_TIMESTAMP
    comment
    '更新时间',
    index
    idx_postId
(
    postId
),
    index idx_userId
(
    userId
)
    ) comment '帖子收藏';


-- 接口表
CREATE TABLE `interface_info`
(
    `id`              bigint       NOT NULL COMMENT '主键',
    `user_id`         bigint       NOT NULL COMMENT '创建人 id',
    `name`            varchar(255) NOT NULL COMMENT '接口名称',
    `description`     varchar(512)          DEFAULT NULL COMMENT '描述信息',
    `url`             varchar(512) NOT NULL COMMENT '接口地址',
    `method`          varchar(255) NOT NULL COMMENT '请求方式',
    `request_header`  varchar(512)          DEFAULT NULL COMMENT '请求头',
    `response_header` varchar(512)          DEFAULT NULL COMMENT '响应头',
    `status`          int          NOT NULL DEFAULT '0' COMMENT '接口状态（0-关闭 1-开启）',
    `create_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`       varchar(255) NOT NULL DEFAULT '0' COMMENT '逻辑删除（0-未删除 1-已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
comment '接口';


-- 用户调用接口表
CREATE TABLE `user_interface_info`
(
    `id`              bigint auto_increment NOT NULL COMMENT '主键',
    `user_id`         bigint       NOT NULL COMMENT '调用人 id',
    `interfaceInfoId` bigint       NOT NULL COMMENT '接口 id',
    `total_num`       int                   default 0 NOT NULL COMMENT '总调用次数',
    `left_num`        int                   default 0 NOT NULL COMMENT '剩余调用次数',
    `status`          int                   default 0 NOT NULL COMMENT '0-正常 1-禁用',
    `create_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`       varchar(255) NOT NULL DEFAULT '0' COMMENT '逻辑删除（0-未删除 1-已删除）',
    PRIMARY KEY (`id`)
) comment '用户调用接口';


