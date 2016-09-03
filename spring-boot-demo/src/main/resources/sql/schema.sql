drop database if exists awesome;

create database awesome;

use awesome;

create table user (
    id int not null auto_increment,
    username varchar(50) not null,
    mobile varchar(11) not null,
    email varchar(50),
    password varchar(50) not null,
    admin bool not null,
    name varchar(50) not null,
    image varchar(500),
    created_at datetime not null default current_timestamp,
    unique key idx_email (email),
    key idx_created_at (created_at),
    primary key (id)
) engine=innodb default charset=utf8;

create table blog (
    id int not null auto_increment,
    user_id int not null,
    name varchar(50) not null,
    summary varchar(200) not null,
    content mediumtext not null,
    created_at datetime not null default current_timestamp,
    key idx_created_at (created_at),
    primary key (id)
) engine=innodb default charset=utf8;

create table comment (
    id int not null auto_increment,
    blog_id int not null,
    user_id int not null,
    content mediumtext not null,
    created_at datetime not null default current_timestamp,
    key idx_created_at (created_at),
    primary key (id)
) engine=innodb default charset=utf8;

-- email / password:
-- admin@example.com / password

insert into user (email, password, admin, name) values ('admin@example.com', '5f4dcc3b5aa765d61d8327deb882cf99', 1, 'Administrator');
