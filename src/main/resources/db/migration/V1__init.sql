create table categories (id bigserial primary key, title varchar(255));
insert into categories (title)
values
('Food');

create table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories (id));
insert into products (title, price, category_id)
values
('Milk', 85, 1),
('Bread', 25, 1),
('Cheese', 450, 1);

