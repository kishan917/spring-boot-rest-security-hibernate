
DROP SEQUENCE IF EXISTS HIBERNATE_SEQUENCE;
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART WITH 6;

drop table if exists Employee;
CREATE TABLE Employee (
	EMPLOYEE_ID int(10) NOT NULL,
	EMPLOYEE_NAME varchar(255),
	EMPLOYEE_DEPARTMENT varchar(255),
	EMPLOYEE_SALARY bigint(19) NOT NULL,
	PRIMARY KEY (EMPLOYEE_ID)
);

drop table if exists users;
drop table if exists authorities;
  create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(70) not null,
      enabled boolean not null);

  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);


drop table if exists CUSTOMER;
CREATE TABLE CUSTOMER (
	id int(11) NOT NULL AUTO_INCREMENT,
	customerName varchar(255) DEFAULT NULL,
	email varchar(255) DEFAULT NULL,
	PRIMARY KEY (id)
);

