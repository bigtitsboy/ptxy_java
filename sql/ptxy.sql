-- ----------------------------
-- 1、商品分类
-- ----------------------------
drop table if exists goods_category;
create table goods_category (
  category_id       bigint(20)      not null auto_increment    comment '分类ID',
  category_name     varchar(50)     not null                   comment '分类名称',
  parent_id         bigint(20)      default 0                  comment '父分类ID',
  order_num         int(4)          default 0                  comment '显示顺序',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (category_id)
) engine=innodb auto_increment=200 comment = '商品分类表';

-- ----------------------------
-- 2、二手商品
-- ----------------------------
drop table if exists secondhand_goods;
create table secondhand_goods (
  goods_id          bigint(20)      not null auto_increment    comment '商品ID',
  goods_name        varchar(200)    not null                   comment '商品名称',
  goods_content     varchar(200)    not null                   comment '商品描述',
  goods_price       decimal(8,2)    not null                   comment '商品价格',
  category_id       bigint(20)      not null                   comment '分类ID',
  user_id           bigint(20)      not null                   comment '用户ID',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  image_path_id     varchar(32)     default ''                 comment '图片路径id',
  goods_count       bigint(20)      default 0                  comment '商品浏览量',
  status            char(1)         not null                   comment '商品状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (goods_id)
) engine=innodb auto_increment=200 comment = '二手商品表';

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品分类', '2008', '1', 'goodsCategory', 'goods/goodsCategory/index', 1, 0, 'C', '0', '0', 'goods:goodsCategory:list', '#', 'admin', sysdate(), '', null, '商品分类菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品分类查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'goods:goodsCategory:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品分类新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'goods:goodsCategory:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品分类修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'goods:goodsCategory:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品分类删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'goods:goodsCategory:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品分类导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'goods:goodsCategory:export',       '#', 'admin', sysdate(), '', null, '');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('二手商品', '2008', '1', 'secondhandGoods', 'goods/secondhandGoods/index', 1, 0, 'C', '0', '0', 'goods:secondhandGoods:list', '#', 'admin', sysdate(), '', null, '二手商品菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('二手商品查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'goods:secondhandGoods:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('二手商品新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'goods:secondhandGoods:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('二手商品修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'goods:secondhandGoods:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('二手商品删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'goods:secondhandGoods:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('二手商品导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'goods:secondhandGoods:export',       '#', 'admin', sysdate(), '', null, '');

-- ----------------------------
-- 3、移动端菜单表
-- ----------------------------
drop table if exists app_menu;
create table app_menu (
  menu_id           bigint(20)      not null auto_increment    comment '菜单ID',
  menu_name         varchar(50)     not null                   comment '菜单名称',
  parent_id         bigint(20)      default 0                  comment '父菜单ID',
  order_num         int(4)          default 0                  comment '显示顺序',
  path              varchar(200)    default ''                 comment '路由地址',
  component         varchar(255)    default null               comment '组件路径',
  query             varchar(255)    default null               comment '路由参数',
  is_frame          int(1)          default 1                  comment '是否为外链（0是 1否）',
  is_cache          int(1)          default 0                  comment '是否缓存（0缓存 1不缓存）',
  menu_type         char(1)         default ''                 comment '菜单类型（M目录 C菜单 F按钮）',
  visible           char(1)         default 0                  comment '菜单状态（0显示 1隐藏）',
  status            char(1)         default 0                  comment '菜单状态（0正常 1停用）',
  icon              varchar(100)    default '#'                comment '菜单图标',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (menu_id)
) engine=innodb auto_increment=500 comment = '移动端菜单表';

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('移动端菜单', '2036', '1', 'appMenu', 'controller/appMenu/index', 1, 0, 'C', '0', '0', 'controller:appMenu:list', '#', 'admin', sysdate(), '', null, '移动端菜单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('移动端菜单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'controller:appMenu:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('移动端菜单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'controller:appMenu:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('移动端菜单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'controller:appMenu:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('移动端菜单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'controller:appMenu:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('移动端菜单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'controller:appMenu:export',       '#', 'admin', sysdate(), '', null, '');

-- ----------------------------
-- 4、会员信息表
-- ----------------------------
drop table if exists member_info;
create table member_info (
  member_id         varchar(32)     not null                   comment '会员ID',
  member_name       varchar(30)     not null                   comment '会员账号',
  nick_name         varchar(30)     not null                   comment '会员昵称',
  user_type         varchar(2)      default '00'               comment '用户类型（00系统用户）',
  email             varchar(50)     default ''                 comment '用户邮箱',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  sex               char(1)         default '0'                comment '用户性别（0男 1女 2未知）',
  avatar            varchar(100)    default ''                 comment '头像地址',
  password          varchar(100)    default ''                 comment '密码',
  status            char(1)         default '0'                comment '帐号状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  login_ip          varchar(128)    default ''                 comment '最后登录IP',
  login_date        datetime                                   comment '最后登录时间',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (member_id)
) engine=innodb  comment = '会员信息表';

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员信息', '2000', '1', 'member', 'controller/member/index', 1, 0, 'C', '0', '0', 'controller:member:list', '#', 'admin', sysdate(), '', null, '会员信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'controller:member:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'controller:member:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'controller:member:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'controller:member:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'controller:member:export',       '#', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 5、图片路径表
-- ----------------------------
drop table if exists image_url;
create table image_url (
  image_path_id     varchar(32)                                comment '图片路径id',
  image_path        varchar(255)    default ''                 comment '图片路径'
) engine=innodb  comment = '图片路径表';