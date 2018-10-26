drop table  if exists user_payment;
create table user_payment(
id int(11) not null AUTO_INCREMENT,
user_id int(11)  not null comment '用户id',
remainder double(11,2) not null  DEFAULT '0.00' COMMENT '余额',
PRIMARY KEY (`id`),
UNIQUE KEY `IDX_USER_ID` (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户余额表';

drop table  if exists t_goods_storage;
create table t_goods_storage(
id int(11) not null AUTO_INCREMENT,
goods_id int(11) not null comment '商品id',
amount int(11) not null   COMMENT '数量',
store_id int(11) not null  comment '门店id',
name varchar(50) not null COMMENT '商品名称',
PRIMARY KEY (`id`),
KEY `IDX_STORE_ID` (`store_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品库存表';