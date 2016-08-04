
create database shopping default character set utf8;

show databases;

use shopping;


drop table if exists account;

drop table if exists commodity;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table account
(
   id                   int not null auto_increment,
   user_name            varchar(20) not null,
   password             varchar(20) not null,
   nick_name            varchar(20) not null,
   mobile               varchar(11),
   email                varchar(40),
   sex                  varchar(2) not null default '男' check(sex="男" or sex="女"),
   photo                varchar(100),
   birth_date           date,
   lastLoginTime        datetime,
   createTime           datetime,
   updateTime           datetime,
   userType             int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity
(
   id                   int not null auto_increment,
   saler_id				int not null,
   classify_1           varchar(6) not null,
   classify_2           varchar(6) not null,
   title                varchar(50),
   description          varchar(100),
   picture              varchar(500),
   price                float not null default 0,
   status               int not null default 0,
   address              varchar(50),
   discount             float not null default 0,
   sell_start			datetime not null,
   sell_time			int,
   createTime           datetime,
   updateTime           datetime,
   primary key (id)
);

