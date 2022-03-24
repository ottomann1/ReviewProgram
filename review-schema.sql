

CREATE DATABASE review;

USE review;

CREATE TABLE customer(
customer_id int NOT NULL PRIMARY KEY,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
phone_number varchar(30),
email_address varchar(50)
);

CREATE TABLE address(
address_id int NOT NULL PRIMARY KEY,
street_name varchar(50),
street_number int,
postal_number char(5),
city varchar(50)
);

CREATE TABLE restaurant(
restaurant_id int NOT NULL PRIMARY KEY,
restaurantName varchar(50),
address_id int,
restaurantDescription varchar(255),
FOREIGN KEY(address_id) REFERENCES address(address_id)
);

CREATE TABLE review(
review_id int NOT NULL PRIMARY KEY,
customer_id int NOT NULL,
restaurant_id int NOT NULL,
stars int,
reviewText text,
FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id)
);








 



