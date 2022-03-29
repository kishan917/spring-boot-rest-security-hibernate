drop table if exists table_default;
create table table_default(
	name_default varchar(20)
);

drop table if exists CUSTOMER;
CREATE TABLE CUSTOMER (
	id int(11) NOT NULL AUTO_INCREMENT,
	customerName varchar(255) DEFAULT NULL,
	email varchar(255) DEFAULT NULL,
	PRIMARY KEY (id)
);
insert into CUSTOMER(id, customerName, email) values(1, 'Customer_1', 'cust1@customer.com');
