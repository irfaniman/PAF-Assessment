CREATE DATABASE eshop;

USE eshop;

CREATE TABLE customers
(
    name varchar(32) not null,
    address varchar(128) not null,
    email varchar(128) not null,
    primary key(name)

);

INSERT INTO 
    customers (name, address, email)
VALUES 
    ('fred', '201 Cobblestone Lane', 'fredflintstone@bedrock.com'),
    ('sherlock', '221B Baker Street, London', 'sherlock@consultingdetective.org'),
    ('spongebob', '124 Conch Street, Bikini Bottom', 'spongebob@yahoo.com'),
    ('jessica' '698 Candlewood Land, Cabot Cove', 'fletcher@gmail.com'),
    ('dursley', '4 Privet Drive, Little Whinging, Surrey', 'dursley@gmail.com');


CREATE TABLE order
(

	orderId Long not null,
	deliveryId Long not null,
    name varchar(32) not null, 
	status;
	orderDate;
    primary key(orderId),

);

CREATE TABLE order_status
(
    order_id
    delivery_id
    status
    status_update
);



