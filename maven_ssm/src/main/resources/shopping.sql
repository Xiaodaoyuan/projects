
create database shopping default character set utf8;

show databases;

use shopping;


drop table if exists account;

drop table if exists commodity;


create table account
(
   id                   int not null auto_increment,
   userName             varchar(20),
   password             varchar(20),
   nickName             varchar(20),
   mobile               varchar(11),
   email                varchar(40),
   gender               varchar(2),
   photo                varchar(100),
   birthDate            date,
   lastLoginTime        datetime,
   createTime           datetime,
   updateTime           datetime,
   userType             int,
   deleted              varchar(5),
   primary key (id)
);

create table commodity
(
   id                   int not null auto_increment,
   salerId				int not null,
   categoryFirst        varchar(6),
   categorySecond       varchar(6),
   title                varchar(50),
   description          varchar(100),
   picture              varchar(500),
   price                float,
   status               int,
   address              varchar(50),
   discount             float,
   sellStart			datetime,
   sellTime			    int,
   createTime           datetime,
   updateTime           datetime,
   deleted              varchar(5),
   primary key (id)
);

