drop database shopping;

create database shopping default character set utf8;

show databases;

use shopping;

drop table user;

create table user(
	id int primary key auto_increment,
	name varchar(10) not null,
	family_name varchar(10) not null,
	user_name varchar(20) not null,
	password varchar(20) not null,
	email varchar(40) not null,
	sex varchar(2) not null default '男' check(sex="男" or sex="女") ,
	photo varchar(100) not null	,
	enjoy varchar(100),
	birth_date date not null,
	flag varchar(50) default '用户'
);
desc user;
select * from user;
insert into user values('1','管理员','贵美','admin','123456','admin@163.com','男','photos/admin.jpg','唱歌','1977-09-30','管理员');

insert into user values(3,'四','李','lisi','1111','lisi@qq.com','女','lisi.jpg','跳舞','2008-12-12','管理员');
insert into user(name,family_name,user_name,password,email,sex,photo,enjoy,birth_date,flag) values('四','李','lisi','1111','lisi@qq.com','女','lisi.jpg','跳舞','2008-12-12','用户');
select* from goods_info;
desc goods_info;
desc goods_order;


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/10/14 11:29:13                          */
/*==============================================================*/


drop table if exists ad;

drop table if exists goods_info;

drop table if exists goods_order;

drop table if exists user;

/*==============================================================*/
/* Table: ad                                                    */
/*==============================================================*/
create table ad
(
   ad_id                int not null auto_increment,
   goods_name            varchar(20),
   ad_name              char(20) not null,
   goods_id             int not null,
   en_pic               char(100),
   primary key (ad_id)
);
insert into ad(goods_name, ad_name, goods_id,en_pic ) values('1','滚动广告',273,'22.png');
select * from ad;
select * from ad

/*==============================================================*/
/* Table: goods_info                                            */
/*==============================================================*/
create table goods_info
(
   goods_id              int not null auto_increment,
   saler_id				int not null,
   classify_1           varchar(20) not null,
   classify_2           varchar(20) not null,
   title                varchar(50),
   description          varchar(100),
   picture              varchar(500),
   price                float not null default 0,
   trsptat_pay          varchar(10) not null,
   curr_sal_nub         int not null default 0,
   tol_sal_nub          int not null default 0,
   page_view            int not null default 0,
   goods_addr             varchar(50) not null,
   goods_type            varchar(20) not null,
   discount             float not null default 0,
   sell_star			datetime not null,
   sell_time			int,
   primary key (goods_id)
);
desc goods_info;
select * from goods_info;
delete from goods_info;
insert into goods_info values(1,1,'1','1','1','1','1',1,'1',1,2,1,'1','1',1,'2014-10-14 16:18:27',10);
insert into goods_info(saler_id,classify_1,classify_2,title,description,picture,price,trsptat_pay,curr_sal_nub,tol_sal_nub,page_view,goods_addr,goods_type,discount,sell_star,sell_time) values(1,'1','1','1','1','1',1,'1',1,2,1,'1','1',1,'2014-10-14 16:18:27',10);
/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table goods_order
(
   order_id             int not null auto_increment,
   order_nub            varchar(20) not null,
   buyer_id             int not null,
   buy_goods            varchar(200) not null,
   buy_qutity           varchar(200) not null,
   receiver             varchar(30) not null,
   rec_add              varchar(100) not null,
   rec_pho              varchar(20) not null,
   tol_pays             float not null default 0,
   acc_paid             float not null default 0,
   primary key (order_id)
);
select * from goods_order

insert into goods_order values(1,'23ws',4,'笔记本|','3|','王林','石家庄','1982377899',20000.0,20000.0);
/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   name                 varchar(10) not null,
   family_name          varchar(10) not null,
   user_name            varchar(20) not null,
   password             varchar(20) not null,
   email                varchar(40) not null,
   sex                  varchar(2) not null default '男',
   photo                varchar(100) not null,
   enjoy                varchar(100),
   birth_date           date,
   flag					varchar(10) default '用户',
   primary key (id)
);


alter table ad add constraint FK_Relationship_3 foreign key (goods_id)
      references goods_info (good_id) on delete restrict on update restrict;

alter table goods_order add constraint FK_Relationship_1 foreign key (buyer_id)
      references user (id) on delete restrict on update restrict;

alter table goods_order add constraint FK_Relationship_2 foreign key (saler_id)
      references user (id) on delete restrict on update restrict;
alter table goods_info add constraint FK_Relationship_3 foreign key (saler_id)
      references user (id) on delete restrict on update restrict;

show tables;

desc goods_order;


