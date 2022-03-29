drop table if exists table_h2;
create table table_h2(
	name_h2 varchar(20)
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


