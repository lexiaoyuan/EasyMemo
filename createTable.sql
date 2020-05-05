create table memo
(
    memo_id       int(10) auto_increment
        primary key,
    memo_content  varchar(100) not null,
    memo_account  varchar(50)  not null,
    memo_password varchar(50)  not null,
    memo_note     varchar(300) null,
    memo_date     date         not null,
    user_account  varchar(11)  not null,
    constraint memo_user_user_account_fk
        foreign key (user_account) references user (user_account)
            on update cascade on delete cascade
);

alter table memo add constraint user_account foreign key (user_account) references user(user_account);

alter table memo drop foreign key user_account;
alter table memo drop column user_account;

create table user_memo
(
    user_account varchar(11) not null,
    memo_id int(10) not null,
    primary key (user_account, memo_id),
    foreign key (user_account) references user(user_account),
    foreign key (memo_id) references memo(memo_id)
);

create index memo_id
    on user_memo (memo_id);

create table user
(
    user_account varchar(11) not null
        primary key
);


create table user_memo
(
    user_account varchar(11) not null,
    memo_id      int(10)     not null,
    primary key (user_account, memo_id),
    constraint fk_memo_id
        foreign key (memo_id) references memo (memo_id)
            on update cascade on delete cascade,
    constraint fk_user_account
        foreign key (user_account) references user (user_account)
            on update cascade on delete cascade
);



