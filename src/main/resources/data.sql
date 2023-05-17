-- create roles
INSERT INTO roles (id, name) VALUES ('1', 'ADMIN');
INSERT INTO roles (id, name) VALUES ('2', 'USER');

-- create users
INSERT INTO users (id, username, firstname, lastname, password, email, birthdate, phone_number, description, address_line, premise, city, postal_code, country)
VALUES ('1', 'user1', 'John', 'Doe', 'password1', 'user1@example.com', '1990-01-01', '123456789', 'Description 1', '123 Main St', 'Premise 1', 'City1', '12345', 'Country1');

-- set user rights
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2)