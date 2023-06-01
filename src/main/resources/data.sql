-- create roles
INSERT INTO roles (id, name) VALUES ('1', 'ADMIN');
INSERT INTO roles (id, name) VALUES ('2', 'USER');

-- create users
INSERT INTO users (id, username, firstname, lastname, password, email, birthdate, phone_number, description, address_line, premise, city, postal_code, country)
       VALUES ('2', 'user', 'user', 'user', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy', 'user@example.com', '1990-01-01', '123456789', 'Description user', 'Test street 1', 'Premise 1', 'paris', '750014', 'France'),
       ('1', 'admin', 'admin', 'admin', '$2a$10$PJf3MqpW2aexwqLML51U5exS62wv0rsJ6pKcI7j9aqh9s0HUDtWVu', 'admin@example.com', '1990-01-01', '123456789', 'Description admin','Admin st 2', 'Left apt.', 'Paris', '750001', 'France'),
       ('3', 'user3', 'David', 'Johnson', 'password3', 'user3@example.com', '1985-08-20', '555555555', 'Description 3', '789 Oak St', 'Premise 3', 'Chicago', '23456', 'USA'),
       ('4', 'user4', 'Emily', 'Davis', 'password4', 'user4@example.com', '1995-03-10', '111111111', 'Description 4', '987 Pine St', 'Premise 4', 'Houston', '78901', 'USA'),
       ('5', 'user5', 'Michael', 'Wilson', 'password5', 'user5@example.com', '1998-11-25', '999999999', 'Description 5', '321 Maple St', 'Premise 5', 'Sevilla', '34567', 'Spain'),
       ('6', 'user6', 'Naruto', 'Uzumaki', '12345', 'naruto@example.com', '2000-10-08', '386063686', 'The next Hokage', '15 Ichiban Street', 'Premise 6', 'Tokyo', '34375', 'Japan'),
       ('7', 'user7', 'James', 'Hetfield', 'yeah45', 'jameshetfield@example.com', '1965-11-22', '666666666', 'Best musician in the world', '45 Guitar street', 'Premise 7', 'San Francisco', '84735', 'USA'),
       ('8', 'user8', 'Fernando', 'Alonso', 'password33', 'fernandoalonso@example.com', '1983-03-03', '333333333', 'The GOAT of formula 1', '33 Win Street', 'Premise 8', 'Oviedo', '41008', 'Spain'),
       ('9', 'user9', 'admin2', 'admin2', 'admin2', 'admin2@example.com', '2000-03-03', '125636835', 'admin', '32 admin street', 'Premise admin', 'Paris', '750015', 'France'),
       ('10', 'user10', 'admin3', 'userrr', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy', 'userrrrrrr@example.com', '2000-03-03', '125636835', 'admin', '32 admin street', 'User ', 'Madrid', '750015', 'Spain'),
       ('11', 'user11', 'admin3', 'userrrr', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy', 'userrrrrexample.com', '2000-03-03', '125636835', 'admin', '32 admin street', 'User', 'Madrid', '750015', 'Spain');

-- set user rights
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (4, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (5, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (6, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (7, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (8, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (9, 1);

-- listing
INSERT INTO listings (listing_id, owner_id, description, booking_info, rating, owner_rating, availability_start, availability_end, address_line, premise, city, postal_code, country, main_image)
VALUES ('1', '1', 'Small cozy loft in the center of paris', 'Any other info call me', 0, 0, '2024-01-01', '2024-12-01', 'Brown 69', '4th floor, left', 'Paris', '750001', 'France', 'house-1.png'),
('2', '2', 'Big apartement in the center of paris', 'Any other info call me', 0, 0, '2024-01-02', '2024-12-02', 'Bookish 69', '2th floor, left', 'Paris', '750002', 'France', 'house-3.png'),
('3', '3', 'Modern studio apartment in downtown Paris', 'Contact me for booking details', 0, 0, '2024-03-15', '2024-12-31', 'Rue de la Liberte 123', '7th floor, Apt 12', 'Paris', '750003', 'France', 'house-1.png'),
('4', '4', 'Charming cottage in the outskirts of Paris', 'Please inquire for availability', 0, 0, '2024-02-01', '2024-12-15', 'Chemin des Fleurs 456', 'Garden Cottage', 'Paris', '750004', 'France', 'house-3.png'),
('5', '5', 'Spacious penthouse with panoramic views', 'For bookings, contact the owner', 0, 0, '2024-05-01', '2024-12-31', 'Avenue des Champs-Elysees 789', 'Penthouse Suite', 'Paris', '750005', 'France', 'house-1.png'),
('6', '6', 'Cozy apartment near Eiffel Tower', 'For booking inquiries, please contact the owner', 0, 0, '2024-06-01', '2024-12-31', 'Rue de la Tour 10', '2nd floor, Apt 5', 'Paris', '750006', 'France', 'house-3.png'),
('7', '7', 'Beautiful villa with garden in Paris', 'Contact owner for availability and reservations', 0, 0, '2024-07-01', '2024-12-31', 'Avenue du Jardin 25', 'Villa Flore', 'Paris', '750007', 'France', NULL),
('8', '8', 'Modern loft in vibrant neighborhood', 'Please inquire for booking details', 0, 0, '2024-08-01', '2024-12-31', 'Rue de la Mode 42', '5th floor, Loft 8', 'Paris', '750008', 'France', NULL),
('9', '9', 'Beautiful villa with garden in Paris', 'Contact owner for availability and reservations', 0, 0, '2024-07-01', '2024-12-31', 'Avenue du Jardin 25', 'Villa Flore', 'Paris', '750007', 'France', NULL),
('10', '10', 'Modern loft in vibrant neighborhood', 'Please inquire for booking details', 0, 0, '2024-08-01', '2024-12-31', 'Rue de la Mode 42', '5th floor, Loft 8', 'Madrid', '750008', 'Spain', NULL),
('11', '11', 'Beautiful villa with garden in Madrid', 'Please inquire for booking details', 0, 0, '2024-08-01', '2024-12-31', 'Las ramblas', '6th floor, Loft 8', 'Madrid', '750008', 'Spain', NULL);


-- messages
INSERT INTO messages (sender_id, receiver_id, content, timestamp)
VALUES
       (7, 8, 'Hello User 8, this is User 7!', CURRENT_TIMESTAMP),
       (8, 7, 'Hi User 7, nice to hear from you!', CURRENT_TIMESTAMP),
       (7, 8, 'How are you today?', CURRENT_TIMESTAMP),
       (8, 7, 'I am fine, thank you', CURRENT_TIMESTAMP),
       (7, 8, 'Is it possible to smoke in your home?', CURRENT_TIMESTAMP),
       (8, 7, 'Absolutely no!', CURRENT_TIMESTAMP);

-- services
INSERT INTO services (service_id, service_name, service_description)
VALUES (1, 'Garbage disposal', 'Take out the trash and recycling'),
       (2, 'Plant care', 'Water plants and tend to garden'),
       (3, 'Errand running', 'Run errands, such as picking up dry cleaning or dropping off mail. The owner will let you know in chat.'),
       (4, 'Appliance maintenance', 'Clean and maintain appliances, such as the refrigerator and oven'),
       (5, 'Disinfecting and sanitizing', ' Clean and disinfect high-touch surfaces, such as doorknobs and light switches');

-- constraints
INSERT INTO constraints (constraint_id, constraint_name, constraint_description)
VALUES (1, 'No smoking indoors', 'Smoking indoors is prohibited due to fire hazards and health risks.'),
       (2, 'No pets', 'Pets are not allowed to prevent damage and/or hygiene and health issues.'),
       (3, 'No shoes on carpet', 'Shoes are not allowed on the carpet to keep it clean and prevent wear and tear.'),
       (4, 'No loud music after 10pm', 'Loud music is not allowed after 10pm to respect neighbors and maintain a peaceful environment.'),
       (5, 'No cooking with open flames', 'Cooking with open flames is prohibited due to fire hazards and safety concerns.'),
       (6, 'No leaving doors unlocked', 'Doors must be locked at all times to prevent theft and ensure safety.'),
       (7, 'No food in bedrooms', 'Eating in bedrooms is not allowed to prevent pests and maintain cleanliness.'),
       (8, 'No car space', 'Cars cause pollution and there is not parking spot available. ');
