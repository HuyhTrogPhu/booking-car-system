create table payment (
    id bigint auto_increment primary key,
    customer_id bigint,
    booking_id bigint,
    payment_method varchar(10),
    transaction_id varchar(100),
    amount decimal(19, 2) default 0.00,
    status varchar(50),
    payment_date timestamp default current_timestamp
);