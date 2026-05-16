create table role
(
    id   bigint auto_increment primary key,
    role varchar(10)
);

create table user
(
    id       bigint auto_increment primary key,
    email    text not null,
    username varchar(100) not null,
    password varchar(255) not null,
    role_id  bigint not null,
    is_active boolean,
    constraint fk_user_role foreign key (role_id) references role (id)
);

create table admin
(
    id           bigint auto_increment primary key,
    user_id      bigint not null,
    first_name   varchar(100) not null,
    last_name    varchar(100) not null,
    avatar       varchar(255) not null,
    phone_number varchar(15) not null,
    gender       boolean default true,
    constraint fk_admin_user foreign key (user_id) references user (id) on delete cascade
);

create table customer
(
    id           bigint auto_increment primary key,
    user_id      bigint not null,
    last_name    varchar(255) not null,
    first_name   varchar(100) not null,
    avatar       varchar(255) not null,
    phone_number varchar(15) not null,
    gender       boolean   default true,
    birthday     timestamp default current_timestamp not null,
    address      varchar(255) not null,
    constraint fk_customer_user foreign key (user_id) references user (id) on delete cascade
);

create table driver
(
    id             bigint auto_increment primary key,
    user_id        bigint not null,
    last_name      varchar(100) not null,
    first_name     varchar(100) not null,
    avatar         varchar(255) not null,
    phone_number   varchar(20) not null,
    license_number varchar(50) not null,
    status         varchar(50) not null,
    my_trip        int            default 0,
    total_distance double,
    balance        decimal(19, 2) default 0.00 not null,
    constraint fk_driver_user foreign key (user_id) references user (id) on delete cascade
);
