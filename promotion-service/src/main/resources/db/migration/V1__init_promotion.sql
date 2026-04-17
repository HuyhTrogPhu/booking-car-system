create table promotion (
    id bigint auto_increment primary key,
    code varchar(10),
    title varchar(20),
    description varchar(255),
    discount_type varchar(50),
    discount_value decimal(19, 2) default 0.00,
    max_discount decimal(19, 2) default 0.00,
    start_date timestamp default current_timestamp,
    end_date timestamp default current_timestamp,
    user_limit integer
);

create table promotion_usage (
    id bigint auto_increment primary key,
    promotion_id bigint,
    customer_id bigint,
    booking_id bigint,
    use_at timestamp default current_timestamp,
    constraint fk_promotion_usage foreign key (promotion_id) references promotion(id)
);

create table specially (
    id bigint auto_increment primary key,
    promotion_id bigint,
    from_date timestamp default current_timestamp,
    to_date timestamp default current_timestamp,
    media_url varchar(100),
    content text,
    type varchar(20)
);