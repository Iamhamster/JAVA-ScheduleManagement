USE schedule;

create table schedule (
                          id int auto_increment primary key,
                          name varchar(100) not null,
                          pw varchar(100) not null,
                          todo varchar(255) not null,
                          createDate timestamp default current_timestamp,
                          updateDate timestamp default current_timestamp on update current_timestamp
);