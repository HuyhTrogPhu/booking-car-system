create table payment (
    id bigint auto_increment primary key,
    customer_id bigint not null,
    booking_id bigint not null,
    payment_method varchar(10) not null,
    transaction_id varchar(100) not null,
    amount decimal(19, 2) default 0.00 not null,
    status varchar(50) not null,
    payment_date timestamp default current_timestamp  not null
);