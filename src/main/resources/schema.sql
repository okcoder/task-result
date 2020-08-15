create table schedule (
  id int not null
, user_id  varchar(50) not null
, repeat_type varchar(50) not null
, name varchar(400) not null
, create_time timestamp(3) not null
, update_time timestamp(3)  null
,primary key(id)
);

create table schedule_repeat (
  schedule_id int not null
, day int not null
, create_time timestamp(3) not null
, update_time timestamp(3) not null
,primary key(schedule_id,day)
);


create sequence seq_schedule_id start with 30000;
