-- create roles
INSERT INTO roles (id, name) VALUES ('1', 'ADMIN');
INSERT INTO roles (id, name) VALUES ('2', 'USER');

-- create users
INSERT INTO users (id, username, firstname, lastname, password, email, birthdate, phone_number, description, address_line, premise, city, postal_code, country)
VALUES ('1', 'user1', 'John', 'Doe', 'password1', 'user1@example.com', '1990-01-01', '123456789', 'Description 1', '123 Main St', 'Premise 1', 'Lodz', '12345', 'Poland'),
       ('2', 'user2', 'Jane', 'Smith', 'password2', 'user2@example.com', '1992-05-15', '987654321', 'Description 2', '456 Elm St', 'Premise 2', 'Los Angeles', '67890', 'USA'),
       ('3', 'user3', 'David', 'Johnson', 'password3', 'user3@example.com', '1985-08-20', '555555555', 'Description 3', '789 Oak St', 'Premise 3', 'Chicago', '23456', 'USA'),
       ('4', 'user4', 'Emily', 'Davis', 'password4', 'user4@example.com', '1995-03-10', '111111111', 'Description 4', '987 Pine St', 'Premise 4', 'Houston', '78901', 'USA'),
       ('5', 'user5', 'Michael', 'Wilson', 'password5', 'user5@example.com', '1998-11-25', '999999999', 'Description 5', '321 Maple St', 'Premise 5', 'Sevilla', '34567', 'Spain'),
       ('6', 'user6', 'Naruto', 'Uzumaki', '12345', 'naruto@example.com', '2000-10-08', '386063686', 'The next Hokage', '15 Ichiban Street', 'Premise 6', 'Tokyo', '34375', 'Japan'),
       ('7', 'user7', 'James', 'Hetfield', 'yeah45', 'jameshetfield@example.com', '1965-11-22', '666666666', 'Best musician in the world', '45 Guitar street', 'Premise 7', 'San Francisco', '84735', 'USA'),
       ('8', 'user8', 'Fernando', 'Alonso', 'password33', 'fernandoalonso@example.com', '1983-03-03', '333333333', 'The GOAT of formula 1', '33 Win Street', 'Premise 8', 'Oviedo', '41008', 'Spain'),
       ('9', 'admin', 'admin', 'admin', 'admin', 'admin@example.com', '2000-03-03', '125636835', 'admin', '32 admin street', 'Premise admin', 'Paris', '750015', 'France');

-- set user rights
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (4, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (5, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (6, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (7, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (8, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (9, 1);