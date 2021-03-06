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
  user_id           varchar(32)     not null                   comment '用户ID',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  image_path_id     varchar(32)     default ''                 comment '图片路径id',
  goods_count       bigint(20)      default 0                  comment '商品浏览量',
  status            char(1)         default 0                  comment '商品状态（0正常 1停用）',
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

-- ----------------------------
-- 6、店铺商品表
-- ----------------------------
drop table if exists shop_goods;
create table shop_goods (
  goods_id          bigint(20)      not null auto_increment    comment '商品ID',
  goods_name        varchar(200)    not null                   comment '商品名称',
  goods_content     varchar(200)    not null                   comment '商品描述',
  goods_price       decimal(8,2)    not null                   comment '商品价格',
  goods_number      bigint(20)      default 0                  comment '商品数量',
  category_id       bigint(20)      not null                   comment '分类ID',
  user_id           varchar(32)     not null                   comment '用户ID',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  image_path_id     varchar(32)     default ''                 comment '图片路径id',
  goods_count       bigint(20)      default 0                  comment '商品浏览量',
  status            char(1)         default '0'                comment '商品状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (goods_id)
) engine=innodb auto_increment=500 comment = '店铺商品表';

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('店铺商品', '2007', '1', 'shopGoods', 'goods/shopGoods/index', 1, 0, 'C', '0', '0', 'goods:shopGoods:list', '#', 'admin', sysdate(), '', null, '店铺商品菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('店铺商品查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'goods:shopGoods:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('店铺商品新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'goods:shopGoods:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('店铺商品修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'goods:shopGoods:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('店铺商品删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'goods:shopGoods:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('店铺商品导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'goods:shopGoods:export',       '#', 'admin', sysdate(), '', null, '');

-- ----------------------------
-- 7、收货地址表
-- ----------------------------
drop table if exists consignee_address;
create table consignee_address (
  address_id        bigint(20)      not null auto_increment    comment '收货地址ID',
  user_id           varchar(32)     not null                   comment '用户ID',
  consignee         varchar(30)     not null                   comment '收货人',
  address_content   varchar(200)    not null                   comment '详细地址',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  status            char(1)         default '0'                comment '收货地址状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (address_id)
) engine=innodb auto_increment=500 comment = '收货地址表';

-- ----------------------------
-- 8、商品订单表
-- ----------------------------
drop table if exists shop_order;
create table shop_order (
  order_id          bigint(20)      not null auto_increment    comment '商品订单ID',
  goods_id          bigint(20)      not null                   comment '商品ID',
  goods_number      bigint(20)      default 1                  comment '商品数量',
  order_price       decimal(8,2)    not null                   comment '订单金额',
  buyer_user_id     varchar(32)     not null                   comment '买家用户ID',
  consignee         varchar(30)     not null                   comment '收货人',
  address_content   varchar(200)    not null                   comment '详细地址', 
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  status            char(1)         default '0'                comment '订单状态（0待接单 1商家已接单 2配送中 3配送完成 4取消）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (order_id)
) engine=innodb auto_increment=500 comment = '商品订单表';

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品订单', '2003', '1', 'shopOrder', 'order/shopOrder/index', 1, 0, 'C', '0', '0', 'order:shopOrder:list', '#', 'admin', sysdate(), '', null, '商品订单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品订单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'order:shopOrder:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品订单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'order:shopOrder:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品订单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'order:shopOrder:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品订单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'order:shopOrder:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品订单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'order:shopOrder:export',       '#', 'admin', sysdate(), '', null, '');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址', '2003', '1', 'address', 'order/address/index', 1, 0, 'C', '0', '0', 'order:address:list', '#', 'admin', sysdate(), '', null, '收货地址菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'order:address:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'order:address:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'order:address:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'order:address:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'order:address:export',       '#', 'admin', sysdate(), '', null, '');