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
  goods_price       decimal(2)      not null                   comment '商品价格',
  category_id       bigint(20)      not null                   comment '分类ID',
  user_id           bigint(20)      not null                   comment '用户ID',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  goods_path        varchar(255)    default ''                 comment '商品路径',
  status            char(1)         not null                   comment '商品状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (goods_id)
) engine=innodb auto_increment=200 comment = '二手商品表';