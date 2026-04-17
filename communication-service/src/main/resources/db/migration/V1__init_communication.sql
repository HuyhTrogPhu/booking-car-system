create table call_log (
    id bigint auto_increment primary key,
    caller_id bigint not null ,
    receiver_id bigint not null ,
    booking_id bigint not null ,
    start_time timestamp default current_timestamp,
    end_date timestamp default current_timestamp,
    duration int,
    status varchar(50)
);


create table chat_room (
    id bigint auto_increment primary key,
    participant_one_id bigint not null ,
    participant_two_id bigint not null ,
    booking_id bigint not null ,
    create_at timestamp default current_timestamp,
    status varchar(10)
);

create table chat_message (
    id bigint auto_increment primary key,
    room_id bigint not null ,
    sender_id bigint not null ,
    message_type varchar(10),
    content text,
    media_url varchar(100),
    duration int,
    sent_at timestamp default current_timestamp,
    is_read boolean default false,
    constraint fk_chat_message foreign key (room_id) references chat_room(id)
);
