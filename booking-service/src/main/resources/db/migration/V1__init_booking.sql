create table route
(
    id     bigint auto_increment primary key,
    `to`   varchar(250) not null,
    `from` varchar(250) not null,
    distance double not null
);



create table car
(
    id         bigint auto_increment primary key,
    car_number varchar(50) not null,
    car_type   varchar(50) not null,
    route_id   bigint      not null,
    seats      int         not null,
    constraint fk_route foreign key (route_id) references route (id)
);

create table option_seat
(
    id      bigint auto_increment primary key,
    car_id  bigint not null,
    normal  int    not null,
    special int    not null,
    constraint fk_option_seat foreign key (car_id) references car (id)
);

create table sticket
(
    id              bigint auto_increment primary key,
    car_id          bigint         not null,
    route_id        bigint         not null,
    driver_id       bigint         not null,
    running_date    datetime       not null,
    running_time    datetime       not null,
    price           decimal(19, 2) not null,
    available_seats int            not null,
    sticket_status  varchar(50)    not null,
    constraint fk_sticket_car foreign key (car_id) references car (id),
    constraint fk_sticket_route foreign key (route_id) references route (id)
);

create table booking
(
    id            bigint auto_increment primary key,
    customer_id   bigint                              not null,
    driver_id     bigint                              not null,
    sticket_id    bigint                              not null,
    promotion_id  bigint,
    booking_date  timestamp default current_timestamp not null,
    total_price   decimal(19, 2)                      not null,
    status        varchar(50),
    seat_number   varchar(50)                         not null,
    pickup_point  varchar(150)                        not null,
    dropoff_point varchar(150)                        not null

);


create table cancellation_log
(
    id            bigint auto_increment primary key,
    booking_id    bigint         not null,
    reason        text           not null,
    cancel_by     varchar(50)    not null,
    cancel_time   varchar(50)    not null,
    refund_amount decimal(19, 2) not null,
    constraint fk_cancellation_log foreign key (booking_id) references booking (id)
);

create table rating
(
    id          bigint auto_increment primary key,
    booking_id  bigint not null,
    customer_id bigint not null,
    driver_id   bigint not null,
    rating      int    not null,
    comment     text   not null,
    constraint fk_rating foreign key (booking_id) references booking (id)
);
