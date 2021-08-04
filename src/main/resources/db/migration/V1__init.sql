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


