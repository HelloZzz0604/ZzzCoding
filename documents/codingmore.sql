DROP TABLE IF EXISTS `admin_role_relation`;
CREATE TABLE `admin_role_relation`
(
    admin_role_relation_id bigint auto_increment
        primary key,
    users_id               bigint not null,
    role_id                bigint not null
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = 'admin role relationship table'
  ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    users_id            bigint unsigned auto_increment comment 'users_id'
        primary key,
    user_login          varchar(60)                            null comment 'Login Name',
    user_pass           varchar(255)                           null comment 'Password',
    user_nickname       varchar(50)                            null comment 'Nickname',
    user_email          varchar(100)                           null comment 'Email',
    user_url            varchar(500)                           null comment 'URL',
    user_registered     datetime default '1970-01-02 00:00:00' null comment 'Register Time',
    user_activation_key varchar(255)                           null comment 'Activation Key',
    user_status         int      default 1                     not null comment 'User Status 1 enable 0 disable',
    display_name        varchar(250)                           null comment 'Display Name',
    user_type           int                                    null comment 'User Type 0 :BO 1：Website',
    open_id             varchar(250)                           null comment 'Open ID',
    attribute           json                                   null comment 'Attribute',
    last_login          datetime                               null
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = 'user table'
  ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `resource`;
CREATE TABLE resource
(
    resource_id bigint auto_increment primary key,
    category_id bigint       null comment 'Resource ID',
    create_time datetime default (now())     null comment 'Create Time',
    name        varchar(200) null comment 'Name',
    url         varchar(200) null comment 'URL',
    description varchar(500) null comment 'Description'
)
    COMMENT ='Resource' COLLATE = utf8mb4_general_ci;

DROP TABLE IF EXISTS `menu`;
CREATE TABLE menu
(
    menu_id     bigint    null,
    parent_id   bigint    null,
    create_time timestamp null,
    title       tinytext  null,
    level       int       null,
    sort        int       null,
    name        tinytext  null,
    icon        tinytext  null,
    hidden      int       null,
    path        tinytext  null
);

DROP TABLE IF EXISTS `role`;
CREATE TABLE role
(
    role_id     bigint       null,
    name        tinytext     null,
    description varchar(500) null,
    create_time timestamp    null,
    status      int          null
);

DROP TABLE IF EXISTS `role_menu_relation`;
CREATE TABLE role_menu_relation
(
    role_menu_relation_id bigint null,
    role_id               bigint null,
    menu_id               bigint null
);

DROP TABLE IF EXISTS `role_resource_relation`;
CREATE TABLE role_resource_relation
(
    role_resource_relation_id bigint auto_increment primary key,
    role_id                   bigint null,
    resource_id               bigint null
);

DROP TABLE IF EXISTS `resource_category`;
CREATE TABLE resource_category
(
    resource_category_id bigint    null,
    create_time          timestamp null,
    name                 tinytext  null,
    sort                 int       null
);

DROP TABLE IF EXISTS `banner`;
CREATE TABLE banner
(
    banner_id   bigint unsigned auto_increment comment 'banner_id'
        primary key,
    title       varchar(1023) null,
    description varchar(1023) null,
    status      int default 0 null,
    sort        int default 0 null,
    img_url     varchar(1023) null comment 'image url',
    created_at  datetime      null comment 'create time',
    updated_at  datetime      null comment 'update time',
    constraint banner_banner_id_uindex
        unique (banner_id)
)
    comment 'banner' collate = utf8mb4_unicode_520_ci;

DROP TABLE IF EXISTS `member`;
CREATE TABLE member
(
    id          bigint auto_increment primary key,
    password    varchar(255)                      not null,
    status      int  default 0            not null comment '0 -> disabled; 1 -> enabled',
    create_time datetime default (now()) not null,
    avatar      varchar(200)                      null,
    description varchar(200)                      null,
    email       varchar(64)                      not null,
    username    varchar(32)                      not null
);