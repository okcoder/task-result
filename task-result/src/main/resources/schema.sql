create table schedule (
  id varchar(50) not null
, user_id  varchar(50) not null
, repeat_type varchar(50) not null
, name varchar(400) not null
, category varchar(400) not null
, start_day date not null
, finish_day date not null
, priority_type varchar(50) not null
, priority_index int not null
, estimate_prepare_time  int null
, estimate_time  int null
, estimate_close_time  int null
, start_time time null
, finish_time time null
, create_time timestamp(3) not null
, update_time timestamp(3) null
, primary key(id)
);

create table schedule_repeat_weekly (
  schedule_id varchar(50) not null
, day_of_week varchar(10) not null
, create_time timestamp(3) not null
, update_time timestamp(3) null
, primary key(schedule_id,day_of_week)
);

create table task (
  id varchar(50) not null
, user_id  varchar(50) not null
, task_day date not null
, schedule_id varchar(50) null
, category varchar(400) not null
, title varchar(400) not null
, sub_title varchar(400) null
, priority_type varchar(50) not null
, priority_index int not null
, estimate_prepare_time  int null
, estimate_time  int null
, estimate_close_time  int null
, start_time time null
, finish_time time null
, create_time timestamp(3) not null
, update_time timestamp(3) null
, primary key(id)
);

create table task_action (
  task_id varchar(50) not null
, action varchar(50) not null
, action_time timestamp(3) not null
, create_time timestamp(3) not null
, update_time timestamp(3) null
, primary key(task_id,action)
);

