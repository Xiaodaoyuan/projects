
create database shopping default character set utf8;

show databases;

use shopping;


drop table if exists account;

drop table if exists commodity;


create table account
(
   id                   int not null auto_increment,
   userName             varchar(20) not null,
   password             varchar(20) not null,
   nickName             varchar(20),
   mobile               varchar(11),
   email                varchar(40),
   gender               varchar(2) not null default '男' check(gender="男" or gender="女"),
   photo                varchar(100),
   birthDate            date,
   lastLoginTime        datetime,
   createTime           datetime not null default CURRENT_TIMESTAMP,
   updateTime           datetime not null default CURRENT_TIMESTAMP,
   userType             int not null,
   deleted              varchar(5) not null default 'false',
   primary key (id)
);

create table commodity
(
   id                   int not null auto_increment,
   salerId				int not null,
   categoryFirst          varchar(6) not null,
   categorySecond           varchar(6) not null,
   title                varchar(50),
   description          varchar(100),
   picture              varchar(500),
   price                float not null default 0,
   status               int not null default 0,
   address              varchar(50),
   discount             float not null default 0,
   sellStart			datetime not null,
   sellTime			    int,
   createTime           datetime not null default CURRENT_TIMESTAMP,
   updateTime           datetime not null default CURRENT_TIMESTAMP,
   deleted              varchar(5) not null default 'false',
   primary key (id)
);

