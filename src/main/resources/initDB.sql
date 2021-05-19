drop table if exists orders cascade;
create table orders(
                       id serial primary key,
                       name varchar(255),
                       price int,
                       creation_date timestamp
);