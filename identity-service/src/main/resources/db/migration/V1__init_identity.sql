create table role
(
    id   bigint auto_increment primary key,
    role varchar(10)
);

create table user
(
    id       bigint auto_increment primary key,
    email    text,
    username varchar(100),
    password varchar(255),
    role_id  bigint,
    constraint fk_user_role foreign key (role_id) references role (id)
);

create table admin
(
    id           bigint auto_increment primary key,
    user_id      bigint,
    first_name   varchar(100),
    last_name    varchar(100),
    avatar       varchar(255),
    phone_number varchar(15),
    gender       boolean default true,
    constraint fk_admin_user foreign key (user_id) references user (id) on delete cascade
);

create table customer
(
    id           bigint auto_increment primary key,
    user_id      bigint,
    last_name    varchar(255),
    first_name   varchar(100),
    avatar       varchar(255),
    phone_number varchar(15),
    gender       boolean   default true,
    birthday     timestamp default current_timestamp,
    address      varchar(255),
    constraint fk_customer_user foreign key (user_id) references user (id) on delete cascade
);

create table driver
(
    id             bigint auto_increment primary key,
    user_id        bigint,
    last_name      varchar(100),
    first_name     varchar(100),
    avatar         varchar(255),
    phone_number   varchar(20),
    license_number varchar(50),
    status         varchar(50),
    my_trip        int            default 0,
    total_distance double,
    balance        decimal(19, 2) default 0.00,
    constraint fk_driver_user foreign key (user_id) references user (id) on delete cascade
);