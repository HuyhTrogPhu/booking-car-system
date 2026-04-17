create table booking
(
    id bigint auto_increment primary key,
    customer_id bigint,
    driver_id bigint,
    sticket_id bigint,
    promotion_id bigint,
    booking_date timestamp default current_timestamp,
    total_price decimal(19,2),
    status varchar(50),
    seat_number varchar(50),
    pickup_point varchar(150),
    dropoff_point varchar(150)

);

create table car (
    id bigint auto_increment primary key,
    car_number varchar(50),
    car_type varchar(50),
    seats int
);

create table option_seat (
    id bigint auto_increment primary key,
    car_id bigint,
    normal int,
    special int,
    constraint fk_option_seat foreign key (car_id) references car(id)
);

create table cancellation_log (
    id bigint auto_increment primary key,
    booking_id bigint,
    reason text,
    cancel_by varchar(50),
    cancel_time varchar(50),
    refund_amount decimal(19,2),
    constraint fk_cancellation_log foreign key (booking_id) references booking(id)
);

create table rating (
    id bigint auto_increment primary key,
    booking_id bigint,
    customer_id bigint,
    driver_id bigint,
    rating int,
    comment text,
    constraint fk_rating foreign key (booking_id) references booking(id)
);

create table route (
    id bigint auto_increment primary key,
    `to` varchar(250),
    `from` varchar(250),
    distance double
);

create table sticket (
    id bigint auto_increment primary key,
    car_id bigint,
    route_id bigint,
    driver_id bigint,
    running_date datetime,
    running_time datetime,
    price decimal(19,2),
    available_seats int,
    sticket_status varchar(50),
    constraint fk_sticket_car foreign key (car_id) references car(id),
    constraint fk_sticket_route foreign key (route_id) references route(id)
);