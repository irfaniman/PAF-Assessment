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

CREATE TABLE line_item
(
    item varchar(32) not null,
    quantity int not null,
    primary key (item)
);

-- INSERT INTO
--     line_item (item, quantity)
-- VALUES ();


CREATE TABLE order
(

	orderId varchar(32) not null,
	deliveryId varchar(32) not null,
	status enum('pending','dispatched');
	orderDate date not null;
    primary key(orderId),

);

CREATE TABLE order_status
(
    order_id varchar not null,
    delivery_id varcar not null,
    status enum('pending','dispatched');
    status_update timestamp;
);





