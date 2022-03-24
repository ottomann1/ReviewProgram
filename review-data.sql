


INSERT INTO customer(customer_id, first_name, last_name, phone_number, email_address) VALUES (1, 'John', 'Doe', '345876123', 'johndoe@gmail.com');
INSERT INTO customer(customer_id, first_name, last_name, phone_number, email_address) VALUES (2, 'Jane', 'Doe', '569301347', 'janedoe@gmail.com');   
INSERT INTO customer(customer_id, first_name, last_name, phone_number, email_address) VALUES (3, 'William', 'Smith', '603485109', 'willsmith@gmail.com');
INSERT INTO customer(customer_id, first_name, last_name, phone_number, email_address) VALUES (4, 'Gabriel', 'Simpson', '296024759', 'gabsimpson@gmail.com');
INSERT INTO customer(customer_id, first_name, last_name, phone_number, email_address) VALUES (5, 'Edward', 'Tyson', '904532861', 'edtyson@gmail.com');


INSERT INTO address(address_id, street_name, street_number, postal_number, city) VALUES (1, 'Kungsgatan', 56, '73490', 'Stockholm');
INSERT INTO address(address_id, street_name, street_number, postal_number, city) VALUES (2, 'Drottningsgatan', 23, '86342', 'Goteborg');
INSERT INTO address(address_id, street_name, street_number, postal_number, city) VALUES (3, 'Skolgatan', 98, '91265', 'Malmo');
INSERT INTO address(address_id, street_name, street_number, postal_number, city) VALUES (4, 'Kyrkogatan', 4, '75692', 'Uppsala');
INSERT INTO address(address_id, street_name, street_number, postal_number, city) VALUES (5, 'Marknadsgatan', 29, '16438', 'Umea');


INSERT INTO restaurant(restaurant_id, restaurantName, address_id, restaurantDescription) VALUES (1, 'McDonalds', 3, 'Hamburger restaurant.');
INSERT INTO restaurant(restaurant_id, restaurantName, address_id, restaurantDescription) VALUES (2, 'Pizza Hut', 5, 'Pizzeria'); 
INSERT INTO restaurant(restaurant_id, restaurantName, address_id, restaurantDescription) VALUES (3, 'Sushi Kyoto', 1, 'Japanesse restaurant.');
INSERT INTO restaurant(restaurant_id, restaurantName, address_id, restaurantDescription) VALUES (4, 'Kebab Bagdad', 2, 'Kebab restaurant.');
INSERT INTO restaurant(restaurant_id, restaurantName, address_id, restaurantDescription) VALUES (5, 'Kentucky Fried Chicken', 4, 'Fried chicken restaurant.');


INSERT INTO review(review_id, customer_id, restaurant_id, stars, reviewText) VALUES (1, 3, 4, 4, 'My favourite restaunrant.');
INSERT INTO review(review_id, customer_id, restaurant_id, stars, reviewText) VALUES (2, 1, 2, 3, 'Food is very tasty.');
INSERT INTO review(review_id, customer_id, restaurant_id, stars, reviewText) VALUES (3, 4, 5, 5, 'I like to eat there every day.');
INSERT INTO review(review_id, customer_id, restaurant_id, stars, reviewText) VALUES (4, 2, 3, 1, 'Very expensive and not very good food.');
INSERT INTO review(review_id, customer_id, restaurant_id, stars, reviewText) VALUES (5, 5, 1, 3, 'You get good food for a good price.');
















 



