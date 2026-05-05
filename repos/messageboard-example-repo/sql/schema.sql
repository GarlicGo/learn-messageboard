# 建表语句
# 适用于MySQL 8.0
drop table if exists t_comment;
drop table if exists t_message;
drop table if exists t_report;
drop table if exists t_user;

create table t_comment
(
    comment_id  bigint auto_increment comment '评论ID'
        primary key,
    message_id  bigint                             not null comment '所属于的留言ID',
    floor       int                                not null comment '楼层数',
    user_id     bigint                             not null comment '发布者ID',
    content     varchar(255)                       not null comment '评论内容',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '评论表';

create index t_comment_message_id_index
    on t_comment (message_id);

create table t_message
(
    message_id  bigint auto_increment comment '留言ID'
        primary key,
    user_id     bigint                             not null comment '发布者ID',
    category    tinyint unsigned                   not null comment '类别',
    content     varchar(255)                       not null comment '内容',
    comment_num int      default 0                 not null comment '评论数',
    next_floor  int      default 1                 not null comment '下一楼层数',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '留言表';

create index t_message_category_index
    on t_message (category);

create index t_message_user_id_index
    on t_message (user_id);

create table t_report
(
    report_id   bigint auto_increment comment '举报ID'
        primary key,
    report_type tinyint unsigned                   not null comment '被举报事物的种类',
    target_id   bigint                             not null comment '被举报事物的ID',
    reason      varchar(255)                       not null comment '举报理由',
    user_id     bigint                             not null comment '举报人ID',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint t_report_target_id_user_id_report_type_uindex
        unique (target_id, user_id, report_type)
)
    comment '举报表';

create table t_user
(
    user_id     bigint auto_increment comment '用户ID'
        primary key,
    username    varchar(20)                                not null comment '用户名',
    passwd      char(60)                                   not null comment '密码',
    nickname    varchar(10)      default '未设置昵称'      not null comment '昵称',
    sex         tinyint unsigned default '0'               not null comment '性别',
    user_role   tinyint unsigned default '0'               not null comment '角色',
    create_time datetime         default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime         default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint t_user_username_uindex
        unique (username)
)
    comment '用户表';


# 提示：如果在建表的时候，没有设置自动填充创建和更新时间，可以按照下面的方式修改表，这样就能自动填充创建时间和更新时间了。
# ALTER TABLE t_user
#     MODIFY COLUMN create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP;
# ALTER TABLE t_user
#     MODIFY COLUMN update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;