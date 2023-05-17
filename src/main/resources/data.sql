-- create roles
INSERT INTO roles (id, name)
VALUES ('1', 'ADMIN');
INSERT INTO roles (id, name)
VALUES ('2', 'USER');

-- create users
INSERT INTO users (id, username, firstname, lastname, password, email, birthdate, phone_number, description,
                   address_line, premise, city, postal_code, country)
VALUES ('1', 'user1', 'John', 'Doe', 'password1', 'user1@example.com', '1990-01-01', '123456789', 'Description 1',
        '123 Main St', 'Premise 1', 'City1', '12345', 'Country1');

-- set user rights
INSERT INTO user_roles (user_id, role_id)
VALUES (1, 2);

INSERT INTO listings (listing_id, owner_id, description, photos, booking_info, rating, owner_rating,
                      availability_start, availability_end, address_line, premise, city, postal_code, country)
VALUES ('1', '1', 'Small cozy loft in the center of paris', NULL, 'Any other info call me', 0, 0, '2024-01-01',
        '2024-12-01', 'Qifsharopt 69', '4th floor, left', 'Paris', '750001', 'France');