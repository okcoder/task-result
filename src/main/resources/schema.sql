create table events(
    user_id varchar(50),
    event_id BIGINT,
    event_name varchar(512),
    PRIMARY KEY(user_id,event_id)
);
create table field(
    field_id integer,
    field_name varchar(256),
    field_type varchar(20),
    display_name varchar(256),
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
