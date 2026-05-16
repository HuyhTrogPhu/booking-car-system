create table promotion (
    id bigint auto_increment primary key,
    code varchar(10) not null,
    title varchar(20) not null,
    description varchar(255) not null,
    discount_type varchar(50) not null,
    discount_value decimal(19, 2) default 0.00 not null,
    max_discount decimal(19, 2) default 0.00 not null ,
    start_date timestamp default current_timestamp not null,
    end_date timestamp default current_timestamp not null,
    user_limit integer not null
);

create table promotion_usage (
    id bigint auto_increment primary key,
    promotion_id bigint not null,
    customer_id bigint not null,
    booking_id bigint not null,
    use_at timestamp default current_timestamp not null,
    constraint fk_promotion_usage foreign key (promotion_id) references promotion(id)
);

create table specially (
    id bigint auto_increment primary key,
    promotion_id bigint not null,
    from_date timestamp default current_timestamp not null ,
    to_date timestamp default current_timestamp not null,
    media_url varchar(100) not null,
    content text not null,
    type varchar(20) not null
);