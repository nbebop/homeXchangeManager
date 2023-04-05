CREATE TABLE IF NOT EXISTS user
(
    id            BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name     VARCHAR(255) NOT NULL,
    username      VARCHAR(255) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    age           INT,
    gender        ENUM('MALE', 'FEMALE', 'OTHER'),
    billing_addr  VARCHAR(255),
    description   VARCHAR(1000),
    phone_number  VARCHAR(255) NOT NULL UNIQUE,
    email         VARCHAR(255) NOT NULL UNIQUE
    );