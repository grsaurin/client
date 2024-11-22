--CREATE TYPE genders AS ENUM('male', 'female', 'other', 'N/A');
--CREATE TYPE client_status AS ENUM('ACTIVE', 'INACTIVE', 'IDLE');

CREATE TABLE cities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(300) NOT NULL,
    country VARCHAR(300) NOT NULL
);

CREATE TABLE addresses (
    id SERIAL PRIMARY KEY,
    street VARCHAR(300) NOT NULL,
    house_number VARCHAR(50) NOT NULL,
    CONSTRAINT city_id FOREIGN KEY(id) REFERENCES cities(id)
);

CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL ,
    gender genders,
    age INT NOT NULL,
    id_ci VARCHAR(6) NOT NULL ,
    phone VARCHAR(50) NOT NULL ,
    CONSTRAINT address_id FOREIGN KEY (id) REFERENCES addresses(id),
    password VARCHAR(100) NOT NULL,
    status client_status DEFAULT 'ACTIVE'
);

