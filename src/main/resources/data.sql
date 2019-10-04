drop table user;

create table user(
id int primary key auto_increment,
name varchar(20) not null,
gender varchar(6) not null,
age int);

insert into user(id,name,gender,age) values(10,'chinmay','male',22);
