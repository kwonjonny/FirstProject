CREATE TABLE UserTable (
    id VARCHAR2(50) PRIMARY KEY,
    username VARCHAR2(5) NOT NULL,
    password VARCHAR2(50) NOT NULL,
    name VARCHAR2(50),
    email VARCHAR2(50),
    address VARCHAR2(100),
    phone VARCHAR2(20),
    grade NUMBER(3),
    createDate DATE,
    role VARCHAR2(20)
);

CREATE TABLE Cart (
    id VARCHAR2(50) PRIMARY KEY,
    user_id VARCHAR2(50) UNIQUE,
    FOREIGN KEY (user_id) REFERENCES UserTable (id)
);

CREATE TABLE CartItem (
    id VARCHAR2(50) PRIMARY KEY,
    cart_id VARCHAR2(50),
    item_id VARCHAR2(50),
    count NUMBER(10),
    FOREIGN KEY (cart_id) REFERENCES Cart (id),
    FOREIGN KEY (item_id) REFERENCES Item (id)
);

CREATE TABLE Item (
    id VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    text VARCHAR2(1000),
    price NUMBER(10),
    user_id VARCHAR2(50),
    isSoldOut NUMBER(1),
    count NUMBER(10),
    stock NUMBER(10),
    photo VARCHAR2(200),
    FOREIGN KEY (user_id) REFERENCES UserTable (id)
);

CREATE TABLE Board (
    id VARCHAR2(50) PRIMARY KEY,
    title VARCHAR2(50) NOT NULL,
    text VARCHAR2(1000),
    writer VARCHAR2(50),
    image VARCHAR2(200)
);

select * from UserTable;
