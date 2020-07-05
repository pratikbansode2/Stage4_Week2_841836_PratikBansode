CREATE database IF NOT EXISTS  employee_db;
use employee_db;

create table if not exists  user (id int, active bit(1) , password varchar(255), roles varchar(255), user_name varchar(255) );

insert into user values(1, b'1', "admin", "ROLE_ADMIN", "admin");
insert into user values(2, b'1', "user", "ROLE_USER", "user");

create table if not exists  employee (emp_id int, date_of_birth datetime , name varchar(30), permanent bit(1), salary double);
