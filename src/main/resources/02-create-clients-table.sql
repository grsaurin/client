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

