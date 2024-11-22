CREATE USER sofkaUser;

CREATE DATABASE sofka_assesment;

GRANT ALL PRIVILEGES ON DATABASE sofka_assesment TO sofkaUser;

CREATE TYPE genders AS ENUM('male', 'female', 'other', 'NA');
CREATE TYPE client_status AS ENUM('ACTIVE', 'INACTIVE', 'IDLE');

CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(200) NOT NULL ,
                         gender genders,
                         age INT NOT NULL,
                         id_ci VARCHAR(100) NOT NULL ,
                         phone VARCHAR(50) NOT NULL ,
                         address VARCHAR(300) NOT NULL ,
                         password VARCHAR(100) NOT NULL,
                         status client_status DEFAULT 'ACTIVE'
);

CREATE TYPE account_type AS ENUM('savings', 'deposit', 'regular', 'company');
CREATE TYPE account_status AS ENUM('ACTIVE', 'INACTIVE', 'IDLE', 'BLOQUED');

CREATE TABLE accounts (
                          id SERIAL PRIMARY KEY,
                          account_number VARCHAR(300) NOT NULL,
                          account_type account_type DEFAULT 'savings',
                          balance FLOAT DEFAULT 0,
                          account_status account_status DEFAULT 'ACTIVE',
                          fk_client_id integer REFERENCES clients(id) ON DELETE CASCADE
);

CREATE TYPE movement_types AS ENUM('rent', 'transfer', 'payment', 'others');

CREATE TABLE movements (
                           id SERIAL PRIMARY KEY,
                           account_id integer REFERENCES accounts(id),
                           mov_type movement_types DEFAULT 'others',
                           amount FLOAT NOT NULL,
                           balance FLOAT NOT NULL,
                           date TIMESTAMP DEFAULT (CURRENT_DATE)
);