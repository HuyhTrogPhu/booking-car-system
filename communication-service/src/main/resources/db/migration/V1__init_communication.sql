create table call_log (
    id bigint auto_increment primary key,
    caller_id bigint not null ,
    receiver_id bigint not null ,
    booking_id bigint not null ,
    start_time timestamp default current_timestamp not null,
    end_date timestamp default current_timestamp,
    duration int,
    status varchar(50)
);


create table chat_room (
    id bigint auto_increment primary key,
    participant_one_id bigint not null ,
    participant_two_id bigint not null ,
    booking_id bigint not null ,
    create_at timestamp default current_timestamp not null,
    status varchar(10) not null
);

create table chat_message (
    id bigint auto_increment primary key,
    room_id bigint not null ,
    sender_id bigint not null ,
    message_type varchar(10) not null,
    content text not null,
    media_url varchar(100) not null,
    duration int not null,
    sent_at timestamp default current_timestamp,
    is_read boolean default false,
    constraint fk_chat_message foreign key (room_id) references chat_room(id)
);
