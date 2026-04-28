create table incentive (
    id bigint auto_increment primary key,
    driver_id bigint not null,
    condition_type varchar(100) not null,
    reward_amount decimal(19, 2) default 0.00 not null,
    `period` varchar(100) not null
);

create table history (
    id bigint auto_increment primary key,
    driver_id bigint not null ,
    incentive_id bigint not null,
    amount_earned decimal(19, 2) default 0.00 not null,
    earn_at timestamp default current_timestamp not null,
    status varchar(255) not null,
    constraint fk_history foreign key (incentive_id) references incentive(id)
);