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
  goods_path        varchar(255)    default ''                 comment '商品路径',
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