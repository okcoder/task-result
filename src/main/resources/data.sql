insert into events values('user',1,'Daily SAPIX 算数');
insert into events values('user',2,'Daily SAPIX 国語');
insert into events values('user',3,'大思英語');
insert into field values (1,'score','number','分数');
insert into field values (2,'realTime','time','実際時間');
insert into event_fields values(1,1,1);
insert into event_fields values(2,1,1);
insert into event_fields values(3,1,1);
insert into event_fields values(3,2,2);

/*
create table field(
    field_id integer,
    field_name BIGINT,
    field_type BIGINT,
    display_name BIGINT,
    PRIMARY KEY(field_id)
);
create table event_fields(
    event_id BIGINT,
    field_id integer,
    sort_index integer,
    PRIMARY KEY(event_id,field_id)
);
create table task(
    event_id BIGINT,
    task_id BIGINT,
    scheduled_date date,
    PRIMARY KEY(event_id,task_id)
);
create table task_result(
    event_id BIGINT,
    task_id BIGINT,
    result_id BIGINT,
    from_time datetime,
    to_time datetime,
    duration time,
    PRIMARY KEY(event_id,task_id,result_id)
);
create table field_result_number(
    result_id BIGINT,
    field_id integer,
    value integer,
    PRIMARY KEY(result_id,field_id)
);
create table field_result_text(
    result_id BIGINT,
    field_id integer,
    value varchar(1000),
    PRIMARY KEY(result_id,field_id)
);
create table field_result_datetime(
    result_id BIGINT,
    field_id integer,
    value datetime,
    PRIMARY KEY(result_id,field_id)
);
create table field_result_boolean(
    result_id BIGINT,
    field_id integer,
    value TINYINT,
    PRIMARY KEY(result_id,field_id)
);
create table field_result_time(
    result_id BIGINT,
    field_id integer,
    value time,
    PRIMARY KEY(result_id,field_id)
);
*/