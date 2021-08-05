create table users
(
    id         bigserial primary key,
    username   varchar(30) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);


create table categories
(
    id         bigserial primary key,
    title      varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title) values ('Food');


create table products (
id bigserial primary key,
title varchar(255),
price numeric(8, 2) not null,
category_id bigint references categories (id),
created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp);
insert into products (title, price, category_id)
values
('P1', 85,1),
('P2', 25,1),
('P3', 450,1),
('P4', 85,1),
('P5', 25,1),
('P6', 450,1),
('P7', 85,1),
('P8', 25,1),
('P9', 450,1),
('P10', 85,1),
('P11', 25,1),
('P12', 450,1),
('P13', 85,1),
('P14', 25,1),
('P15', 450,1),
('P16', 85,1),
('P17', 25,1),
('P18', 450,1),
('P19', 25,1),
('P20', 450,1);

create table orders
(
    id         bigserial primary key,
    price      numeric(8, 2) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table order_items
(
    id                bigserial primary key,
    price             numeric(8, 2) not null,
    price_per_product numeric(8, 2) not null,
    product_id        bigint references products (id),
    order_id          bigint references products (id),
    quantity          int,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);


