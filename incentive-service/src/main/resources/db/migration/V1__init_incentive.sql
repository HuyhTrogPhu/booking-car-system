create table incentive (
    id bigint auto_increment primary key,
    driver_id bigint,
    condition_type varchar(100),
    reward_amount decimal(19, 2) default 0.00,
    `period` varchar(100)
);

create table history (
    id bigint auto_increment primary key,
    driver_id bigint not null ,
    incentive_id bigint,
    amount_earned decimal(19, 2) default 0.00,
    earn_at timestamp default current_timestamp,
    status varchar(255),
    constraint fk_history foreign key (incentive_id) references incentive(id)
);