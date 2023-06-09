-- create roles
INSERT INTO roles (id, name)
VALUES ('1', 'ROLE_ADMIN');
INSERT INTO roles (id, name)
VALUES ('2', 'ROLE_USER');

-- create users
--admins
INSERT INTO users (id, username, firstname, lastname, password, email, birthdate, phone_number, description,
                   address_line, premise, city, postal_code, country)
VALUES ('1', 'admin', 'admin', 'admin', '$2a$10$PJf3MqpW2aexwqLML51U5exS62wv0rsJ6pKcI7j9aqh9s0HUDtWVu',
        'admin@example.com', '1990-01-01', '123456789', 'Description admin', 'Admin st 2', 'Left apt.', 'Paris',
        '750001', 'France'),
       ('9', 'user9', 'admin2', 'admin2', 'admin2', 'admin2@example.com', '2000-03-03', '125636835', 'admin',
        '32 admin street', 'Premise admin', 'Paris', '750015', 'France');

--regular users
INSERT INTO users (id, username, firstname, lastname, password, email, birthdate, phone_number, description,
                   address_line, premise, city, postal_code, country)
VALUES ('2', 'user', 'user', 'user', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy', 'user@example.com',
        '1990-01-01', '123456789', 'Description user', 'Test street 1', 'Premise 1', 'paris', '750014', 'France'),
       ('3', 'user3', 'David', 'Johnson', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'user3@example.com', '1985-08-20', '555555555', 'Description 3', '789 Oak St', 'Premise 3', 'Chicago', '23456',
        'USA'),
       ('4', 'user4', 'Emily', 'Davis', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'user4@example.com', '1995-03-10', '111111111', 'Description 4', '987 Pine St', 'Premise 4', 'Houston', '78901',
        'USA'),
       ('5', 'user5', 'Michael', 'Wilson', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'user5@example.com', '1998-11-25', '999999999', 'Description 5', '321 Maple St', 'Premise 5', 'Sevilla',
        '34567', 'Spain'),
       ('6', 'user6', 'Naruto', 'Uzumaki', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'naruto@example.com', '2000-10-08', '386063686', 'The next Hokage', '15 Ichiban Street', 'Premise 6', 'Tokyo',
        '34375', 'Japan'),
       ('7', 'user7', 'James', 'Hetfield', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'jameshetfield@example.com', '1965-11-22', '666666666', 'Best musician in the world', '45 Guitar street',
        'Premise 7', 'San Francisco', '84735', 'USA'),
       ('8', 'user8', 'Fernando', 'Alonso', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'fernandoalonso@example.com', '1983-03-03', '333333333', 'The GOAT of formula 1', '33 Win Street', 'Premise 8',
        'Oviedo', '41008', 'Spain'),
       ('10', 'user10', 'admin3', 'userrr', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'userrrrrrr@example.com', '2000-03-03', '125636835', 'admin', '32 admin street', 'User ', 'Madrid', '750015',
        'Spain'),
       ('11', 'user11', 'admin3', 'userrrr', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'userrrrrexample.com', '2000-03-03', '125636835', 'admin', '32 admin street', 'User', 'Madrid', '750015',
        'Spain'),
       ('12', 'user12', 'John', 'Smith', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'johnsmith@example.com', '1992-05-15', '123456789', 'Description 12', '123 Elm St', 'Premise 12', 'New York',
        '10001', 'USA'),
       ('13', 'user13', 'Emma', 'Johnson', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'emmajohnson@example.com', '1991-08-10', '987654321', 'Description 13', '456 Oak St', 'Premise 13',
        'Los Angeles', '90001', 'USA'),
       ('14', 'user14', 'Sophia', 'Lee', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'sophialee@example.com', '1995-12-25', '555555555', 'Description 14', '789 Maple St', 'Premise 14', 'Toronto',
        'M5J 2H7', 'Canada'),
       ('15', 'user15', 'Oliver', 'Garcia', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'olivergarcia@example.com', '1994-03-18', '666666666', 'Description 15', '321 Main St', 'Premise 15',
        'Mexico City', '06500', 'Mexico'),
       ('16', 'user16', 'Mia', 'Rodriguez', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'miarodriguez@example.com', '1998-09-30', '999999999', 'Description 16', '456 Elm St', 'Premise 16', 'Sydney',
        '2000', 'Australia'),
       ('17', 'user17', 'Noah', 'Martinez', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'noahmartinez@example.com', '1993-07-12', '111111111', 'Description 17', '789 Oak St', 'Premise 17', 'London',
        'WC2N 5DU', 'United Kingdom'),
       ('18', 'user18', 'Ava', 'Lopez', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'avalopez@example.com', '1997-02-28', '222222222', 'Description 18', '123 Maple St', 'Premise 18', 'Paris',
        '75010', 'France'),
       ('19', 'user19', 'Liam', 'Harris', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'liamharris@example.com', '1996-11-07', '333333333', 'Description 19', '456 Oak St', 'Premise 19', 'Berlin',
        '10115', 'Germany'),
       ('20', 'user20', 'Isabella', 'Clark', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'isabellaclark@example.com', '1990-04-22', '444444444', 'Description 20', '789 Elm St', 'Premise 20', 'Tokyo',
        '100-0001', 'Japan'),
       ('21', 'user21', 'Sophie', 'Brown', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'sophiebrown@example.com', '1992-07-17', '555555555', 'Description 21', '987 Maple St', 'Premise 21', 'Toronto',
        'M5J 1A7', 'Canada'),
       ('22', 'user22', 'Daniel', 'Taylor', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'danieltaylor@example.com', '1989-11-03', '666666666', 'Description 22', '321 Oak St', 'Premise 22',
        'Los Angeles', '90001', 'USA'),
       ('23', 'user23', 'Olivia', 'Anderson', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'oliviaanderson@example.com', '1991-04-29', '777777777', 'Description 23', '654 Elm St', 'Premise 23',
        'Mexico City', '06500', 'Mexico'),
       ('24', 'user24', 'Ethan', 'Thomas', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'ethanthomas@example.com', '1995-09-12', '888888888', 'Description 24', '456 Main St', 'Premise 24', 'Sydney',
        '2000', 'Australia'),
       ('25', 'user25', 'Sofia', 'White', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'sofiawhite@example.com', '1993-12-07', '999999999', 'Description 25', '789 Oak St', 'Premise 25', 'London',
        'WC2N 4DJ', 'United Kingdom'),
       ('26', 'user26', 'Lucas', 'Gonzalez', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'lucasgonzalez@example.com', '1998-01-25', '111111111', 'Description 26', '123 Pine St', 'Premise 26', 'Paris',
        '75014', 'France'),
       ('27', 'user27', 'Luna', 'Rodriguez', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'lunarodriguez@example.com', '1996-06-19', '222222222', 'Description 27', '456 Oak St', 'Premise 27', 'Berlin',
        '10117', 'Germany'),
       ('28', 'user28', 'Benjamin', 'Harris', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'benjaminharris@example.com', '1990-09-02', '333333333', 'Description 28', '789 Maple St', 'Premise 28',
        'Tokyo', '100-0002', 'Japan'),
       ('29', 'user29', 'Victoria', 'Clark', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'victoriaclark@example.com', '1988-12-15', '444444444', 'Description 29', '321 Elm St', 'Premise 29', 'Toronto',
        'M5J 2N8', 'Canada'),
       ('30', 'user30', 'Henry', 'Lewis', '$2a$10$nOGhgxh/uWfa.DVZQmkW9.Tp6fpP3rkk5sVwvXGBrwrn24AvLQYuy',
        'henrylewis@example.com', '1994-05-31', '555555555', 'Description 30', '654 Oak St', 'Premise 30',
        'Los Angeles', '90001', 'USA');

-- set user rights
INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (3, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (4, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (5, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (6, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (7, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (8, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (9, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (10, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (11, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (12, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (13, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (14, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (15, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (16, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (17, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (18, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (19, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (20, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (21, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (22, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (23, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (24, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (25, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (26, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (27, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (28, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (29, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (30, 2);

-- listing
INSERT INTO listings (listing_id, owner_id, description, booking_info, rating, owner_rating, availability_start,
                      availability_end, address_line, premise, city, postal_code, country)
VALUES ('1', '1', 'Small cozy loft in the center of paris', 'Any other info call me', 5, 0, '2024-01-01', '2024-12-01',
        'Brown 69', '4th floor, left', 'Paris', '750001', 'France'),
       ('2', '2', 'Big apartement in the center of paris', 'Any other info call me', 4, 0, '2024-01-02', '2024-12-02',
        'Bookish 69', '2th floor, left', 'Paris', '750002', 'France'),
       ('3', '3', 'Modern studio apartment in downtown Paris', 'Contact me for booking details', 3, 0, '2024-03-15',
        '2024-12-31', 'Rue de la Liberte 123', '7th floor, Apt 12', 'Paris', '750003', 'France'),
       ('4', '4', 'Charming cottage in the outskirts of Paris', 'Please inquire for availability', 4, 0, '2024-02-01',
        '2024-12-15', 'Chemin des Fleurs 456', 'Garden Cottage', 'Paris', '750004', 'France'),
       ('5', '5', 'Spacious penthouse with panoramic views', 'For bookings, contact the owner', 5, 0, '2024-05-01',
        '2024-12-31', 'Avenue des Champs-Elysees 789', 'Penthouse Suite', 'Paris', '750005', 'France'),
       ('6', '6', 'Cozy apartment near Eiffel Tower', 'For booking inquiries, please contact the owner', 4, 0,
        '2024-06-01', '2024-12-31', 'Rue de la Tour 10', '2nd floor, Apt 5', 'Paris', '750006', 'France'),
       ('7', '7', 'Beautiful villa with garden in Paris', 'Contact owner for availability and reservations', 4, 0,
        '2024-07-01', '2024-12-31', 'Avenue du Jardin 25', 'Villa Flore', 'Paris', '750007', 'France'),
       ('8', '8', 'Modern loft in vibrant neighborhood', 'Please inquire for booking details', 3, 0, '2024-08-01',
        '2024-12-31', 'Rue de la Mode 42', '5th floor, Loft 8', 'Paris', '750008', 'France'),
       ('9', '9', 'Beautiful villa with garden in Paris', 'Contact owner for availability and reservations', 4, 0,
        '2024-07-01', '2024-12-31', 'Avenue du Jardin 25', 'Villa Flore', 'Paris', '750007', 'France'),
       ('10', '10', 'Modern loft in vibrant neighborhood', 'Please inquire for booking details', 5, 0, '2024-08-01',
        '2024-12-31', 'Rue de la Mode 42', '5th floor, Loft 8', 'Madrid', '750008', 'Spain'),
       ('11', '11', 'Beautiful villa with garden in Madrid', 'Please inquire for booking details', 4, 0, '2024-08-01',
        '2024-12-31', 'Las ramblas', '6th floor, Loft 8', 'Madrid', '750008', 'Spain'),
       ('12', '12', 'Cozy apartment in Chicago', 'For booking inquiries, please contact the owner', 3, 0, '2024-06-01',
        '2024-12-31', '123 Oak St', 'Apt 3', 'Chicago', '23456', 'USA'),
       ('13', '13', 'Modern house in Houston', 'Contact owner for availability and reservations', 5, 0, '2024-07-01',
        '2024-12-31', '456 Pine St', 'Premise 4', 'Houston', '78901', 'USA'),
       ('14', '14', 'Beachfront villa in Sevilla', 'Please inquire for booking details', 4, 0, '2024-08-01',
        '2024-12-31', '789 Maple St', 'Premise 5', 'Sevilla', '34567', 'Spain'),
       ('15', '15', 'Spacious apartment in Tokyo', 'Contact me for booking details', 5, 0, '2024-09-01', '2024-12-31',
        '15 Ichiban Street', 'Premise 6', 'Tokyo', '34375', 'Japan'),
       ('16', '16', 'Luxurious penthouse in San Francisco', 'For bookings, contact the owner', 3, 0, '2024-10-01',
        '2024-12-31', '45 Guitar street', 'Premise 7', 'San Francisco', '84735', 'USA'),
       ('17', '17', 'Stylish apartment in Oviedo', 'For booking inquiries, please contact the owner', 4, 0,
        '2024-11-01', '2024-12-31', '33 Win Street', 'Premise 8', 'Oviedo', '41008', 'Spain'),
       ('18', '18', 'Cozy apartment in Paris', 'Contact owner for availability and reservations', 3, 0, '2024-12-01',
        '2024-12-31', '32 admin street', 'Premise admin', 'Paris', '750015', 'France'),
       ('19', '19', 'Modern loft in Madrid', 'Please inquire for booking details', 4, 0, '2024-08-01', '2024-12-31',
        '32 admin street', 'User ', 'Madrid', '750015', 'Spain'),
       ('20', '20', 'Modern loft in Madrid', 'Please inquire for booking details', 5, 0, '2024-08-01', '2024-12-31',
        '32 admin street', 'User', 'Madrid', '750015', 'Spain'),
       ('21', '21', 'Cozy apartment in New York', 'For booking inquiries, please contact the owner', 5, 0, '2024-06-01',
        '2024-12-31', '123 Elm St', 'Premise 12', 'New York', '10001', 'USA'),
       ('22', '22', 'Modern apartment in London', 'Please inquire for booking details', 5, 0, '2024-07-01',
        '2024-12-31', '123 Oxford St', 'Premise 12', 'London', 'W1A 1AA', 'United Kingdom'),
       ('23', '23', 'Luxurious penthouse in Sydney', 'For bookings, contact the owner', 4, 0, '2024-08-01',
        '2024-12-31', '456 George St', 'Premise 12', 'Sydney', '2000', 'Australia'),
       ('24', '24', 'Stylish villa in Melbourne', 'For booking inquiries, please contact the owner', 3, 0, '2024-09-01',
        '2024-12-31', '789 Collins St', 'Premise 12', 'Melbourne', '3000', 'Australia'),
       ('25', '25', 'Cozy apartment in Auckland', 'Contact owner for availability and reservations', 4, 0, '2024-10-01',
        '2024-12-31', '123 Queen St', 'Premise 12', 'Auckland', '1010', 'New Zealand'),
       ('26', '26', 'Modern loft in Singapore', 'Please inquire for booking details', 3, 0, '2024-11-01', '2024-12-31',
        '32 Vettel street', 'Premise admin', 'Singapore', '10000', 'Singapore'),
       ('27', '27', 'Modern loft in Hong Kong', 'Please inquire for booking details', 4, 0, '2024-12-01', '2024-12-31',
        '32 binchiling street', 'User ', 'Hong Kong', '99907', 'Hong Kong'),
       ('28', '28', 'Modern loft in Tokyo', 'Please inquire for booking details', 5, 0, '2024-08-01', '2024-12-31',
        '32 Naruto street', 'User', 'Tokyo', '34375', 'Japan'),
       ('29', '29', 'Modern loft in Seoul', 'Please inquire for booking details', 5, 0, '2024-08-01', '2024-12-31',
        '33 BTS street', 'User', 'Seoul', '06000', 'South Korea'),
       ('30', '30', 'Modern loft in Beijing', 'Please inquire for booking details', 4, 0, '2024-08-01', '2024-12-31',
        '32 Haiki street', 'User', 'Beijing', '100000', 'China');

-- messages
INSERT INTO messages (sender_id, receiver_id, content, timestamp)
VALUES (7, 8, 'Hello User 8, this is User 7!', CURRENT_TIMESTAMP),
       (8, 7, 'Hi User 7, nice to hear from you!', CURRENT_TIMESTAMP),
       (7, 8, 'How are you today?', CURRENT_TIMESTAMP),
       (8, 7, 'I am fine, thank you', CURRENT_TIMESTAMP),
       (7, 8, 'Is it possible to smoke in your home?', CURRENT_TIMESTAMP),
       (8, 7, 'Absolutely no!', CURRENT_TIMESTAMP);

-- services
INSERT INTO services (service_id, service_name, service_description)
VALUES (1, 'Garbage disposal', 'Take out the trash and recycling'),
       (2, 'Plant care', 'Water plants and tend to garden'),
       (3, 'Errand running',
        'Run errands, such as picking up dry cleaning or dropping off mail. The owner will let you know in chat.'),
       (4, 'Appliance maintenance', 'Clean and maintain appliances, such as the refrigerator and oven'),
       (5, 'Disinfecting and sanitizing',
        ' Clean and disinfect high-touch surfaces, such as doorknobs and light switches'),
       (6, 'Pet care', 'Walk, feed, and play with pets'),
       (7, 'Housekeeping', 'Dust, vacuum, mop, and clean bathrooms'),
       (8, 'Laundry', 'Wash, dry, and fold laundry'),
       (9, 'Grocery shopping', 'Shop for groceries and deliver them to the owners home'),
       (10, 'Cooking', 'Cook meals for the owner'),
       (11, 'Massage', 'Provide massages to the owner'),
       (12, 'Yoga', 'Instruct the owner in yoga poses'),
       (13, 'Pilates', 'Instruct the owner in Pilates exercises'),
       (14, 'Personal training', 'Create and implement a fitness plan for the owner'),
       (15, 'Childcare', 'Watch over the owners children'),
       (16, 'Eldercare', 'Provide care for the owners elderly parents'),
       (17, 'Pet sitting', 'Stay with the owners pets while they are away'),
       (18, 'Event planning', 'Plan and execute events for the owner, such as parties or weddings'),
       (19, 'Travel planning',
        'Plan and book travel arrangements for the owner, such as flights, hotels, and car rentals'),
       (20, 'Move-in/move-out assistance', 'Help the owner move into or out of their home');

-- constraints
INSERT INTO constraints (constraint_id, constraint_name, constraint_description)
VALUES (1, 'No smoking indoors', 'Smoking indoors is prohibited due to fire hazards and health risks.'),
       (2, 'No pets', 'Pets are not allowed to prevent damage and/or hygiene and health issues.'),
       (3, 'No shoes on carpet', 'Shoes are not allowed on the carpet to keep it clean and prevent wear and tear.'),
       (4, 'No loud music after 10pm',
        'Loud music is not allowed after 10pm to respect neighbors and maintain a peaceful environment.'),
       (5, 'No cooking with open flames',
        'Cooking with open flames is prohibited due to fire hazards and safety concerns.'),
       (6, 'No leaving doors unlocked', 'Doors must be locked at all times to prevent theft and ensure safety.'),
       (7, 'No food in bedrooms', 'Eating in bedrooms is not allowed to prevent pests and maintain cleanliness.'),
       (8, 'No car space', 'Cars cause pollution and there is not parking spot available. '),
       (9, 'No parties', 'Parties are not allowed to prevent noise and disturbance to neighbors.'),
       (10, 'No smoking on the property',
        'Smoking is prohibited on the property due to fire hazards and health risks.'),
       (11, 'No alcohol consumption', 'Alcohol consumption is prohibited on the property due to safety concerns.'),
       (12, 'No drugs', 'Drug use is prohibited on the property due to safety concerns.'),
       (13, 'No weapons', 'Weapons are prohibited on the property due to safety concerns.'),
       (14, 'No damage to property',
        'Guests are responsible for any damage to the property and will be charged accordingly.'),
       (15, 'No littering', 'Guests are responsible for disposing of their trash properly.'),
       (16, 'No noise after 10pm',
        'Guests are responsible for keeping noise levels down after 10pm to respect neighbors.'),
       (17, 'No guests without prior approval',
        'Guests must obtain prior approval from the owner before bringing any additional guests to the property.'),
       (18, 'No smoking on the balcony', 'Smoking is prohibited on the balcony due to fire hazards and health risks.'),
       (19, 'No candles', 'Candles are prohibited due to fire hazards.'),
       (20, 'No hot tub use without prior approval',
        'Guests must obtain prior approval from the owner before using the hot tub.');

-- images
INSERT INTO images (id, name, listing_id, url, content_type)
VALUES (1, "house-1", 1, "/listing-images/1/house-1.png", "image/x-png"),
       (2, "house-2", 1, "/listing-images/1/house-2.png", "image/x-png"),
       (3, "house-3", 1, "/listing-images/1/house-3.png", "image/x-png"),
       (4, "house-4", 2, "/listing-images/2/house-4.png", "image/x-png"),
       (5, "house-5", 2, "/listing-images/2/house-5.png", "image/x-png"),
       (6, "house-6", 2, "/listing-images/2/house-6.png", "image/x-png"),
       (7, "house-7", 3, "/listing-images/3/house-7.png", "image/x-png"),
       (8, "house-8", 3, "/listing-images/3/house-8.png", "image/x-png"),
       (9, "house-9", 3, "/listing-images/3/house-9.png", "image/x-png"),
       (10, "house-10", 4, "/listing-images/4/house-10.png", "image/x-png"),
       (11, "house-11", 4, "/listing-images/4/house-11.png", "image/x-png"),
       (12, "house-12", 4, "/listing-images/4/house-12.png", "image/x-png"),
       (13, "house-3", 6, "/listing-images/6/house-3.png", "image/x-png"),
       (14, "house-4", 6, "/listing-images/6/house-4.png", "image/x-png"),
       (15, "house-5", 6, "/listing-images/6/house-5.png", "image/x-png"),
       (16, "house-1", 5, "/listing-images/5/house-1.png", "image/x-png"),
       (17, "house-2", 5, "/listing-images/5/house-2.png", "image/x-png"),
       (18, "house-3", 5, "/listing-images/5/house-3.png", "image/x-png"),
       (19, "house-7", 7, "/listing-images/7/house-7.png", "image/x-png"),
       (20, "house-8", 7, "/listing-images/7/house-8.png", "image/x-png"),
       (21, "house-9", 7, "/listing-images/7/house-9.png", "image/x-png"),
       (22, "house-10", 8, "/listing-images/8/house-10.png", "image/x-png"),
       (23, "house-11", 8, "/listing-images/8/house-11.png", "image/x-png"),
       (24, "house-12", 8, "/listing-images/8/house-12.png", "image/x-png"),
       (25, "house-1", 9, "/listing-images/9/house-1.png", "image/x-png"),
       (26, "house-3", 9, "/listing-images/9/house-2.png", "image/x-png"),
       (27, "house-3", 9, "/listing-images/9/house-3.png", "image/x-png"),
       (28, "house-4", 10, "/listing-images/10/house-4.png", "image/x-png"),
       (29, "house-5", 10, "/listing-images/10/house-5.png", "image/x-png"),
       (30, "house-6", 10, "/listing-images/10/house-6.png", "image/x-png");

INSERT INTO bookings (booking_id, accepted, additional_info, booking_end, booking_request_date, booking_start, guest_id,
                      host_id, listing_id)
VALUES (1, false, 'Nice house! I have lifelong experience and I would love to exchange home with you!', '2022-04-03',
        '2022-02-02', '2022-03-03', 3, 2, 2),
       (2, true, 'Great place! I´m excited to stay there.', '2022-05-15', '2022-03-01', '2022-04-01', 4, 6, 5),
       (3, true, 'Looking forward to a wonderful stay!', '2022-07-10', '2022-05-10', '2022-06-10', 8, 4, 3),
       (4, false, 'I hope the place has good internet access.', '2022-08-20', '2022-06-15', '2022-07-15', 7, 5, 8),
       (5, true, 'Excited for the trip!', '2022-09-25', '2022-07-20', '2022-08-25', 6, 7, 4),
       (6, false, 'Looking for a peaceful retreat.', '2022-11-12', '2022-09-15', '2022-10-15', 3, 8, 6),
       (7, true, 'Need a pet-friendly accommodation.', '2023-01-05', '2022-11-10', '2022-12-20', 5, 2, 2),
       (8, true, 'Cant wait to explore!', '2023-11-30', '2023-01-05', '2022-11-10', 3, 2, 2),
       (9, true, 'I hope the place has good internet access.', '2022-12-30', '2022-01-05', '2022-12-10', 8, 2, 2),
       (10, false, 'I hope the place has good internet access.', '2022-07-30', '2022-05-30', '2022-07-10', 7, 2, 2);

-- constraints for existing listings
INSERT INTO listing_constraints (listing_id, constraint_id)
VALUES (1, 16),
       (1, 8),
       (1, 12),
       (2, 10),
       (2, 14),
       (2, 20),
       (3, 6),
       (3, 5),
       (3, 13),
       (4, 7),
       (4, 17),
       (4, 15),
       (5, 18),
       (5, 1),
       (5, 9),
       (6, 11),
       (6, 4),
       (6, 19);

-- services for existing listings
INSERT INTO listing_services (listing_id, service_id)
VALUES (1, 16),
       (1, 8),
       (1, 12),
       (2, 10),
       (2, 14),
       (2, 20),
       (3, 6),
       (3, 5),
       (3, 13),
       (4, 7),
       (4, 17),
       (4, 15),
       (5, 18),
       (5, 1),
       (5, 9),
       (6, 11),
       (6, 4),
       (6, 19);