create table if not exists programme(
    id uuid  default random_uuid() primary key,
    name varchar(255) not null,
    supervisor_id uuid not null,
    foreign key (supervisor_id) references employee(id)
);

insert into programme(id,name,supervisor_id) values('dd00b69f-1f15-4ec5-b66c-c70f94b43f0b','Rigid dump truck','1f0ba65d-c0e9-44ad-895c-e440fad3006d');
