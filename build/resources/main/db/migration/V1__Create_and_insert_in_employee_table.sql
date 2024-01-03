create type role_type as enum('MANAGER','SUPERVISOR','TRAINEE');

create table if not exists employee(
    id uuid default random_uuid() primary key,
    name varchar(255) not null,
    role role_type not null
);

insert into employee(id,name,role) values('4ec0cc46-59ce-4920-a344-3d81d4bc2ce7','Derek','MANAGER');
insert into employee(id,name,role) values('1f0ba65d-c0e9-44ad-895c-e440fad3006d','Martin','SUPERVISOR');
insert into employee(id,name,role) values('ee49ea95-ccce-4154-8180-4624de47d3bd','Gene','TRAINEE');
insert into employee(id,name,role) values('3147fc12-3b98-41e7-84a7-342f65eb9a04','Louise','TRAINEE');
insert into employee(id,name,role) values('0cef81ba-74bd-4731-8884-b45964a30e86','Mary','TRAINEE');
