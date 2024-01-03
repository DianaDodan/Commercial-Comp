create table if not exists enrolment(
    employee_id uuid not null,
    foreign key (employee_id) references employee(id),
    programme_id uuid not null,
    foreign key (programme_id) references programme(id),
    primary key(employee_id,programme_id)
);

insert into enrolment(employee_id,programme_id) values ('ee49ea95-ccce-4154-8180-4624de47d3bd','dd00b69f-1f15-4ec5-b66c-c70f94b43f0b');
insert into enrolment(employee_id,programme_id) values ('3147fc12-3b98-41e7-84a7-342f65eb9a04','dd00b69f-1f15-4ec5-b66c-c70f94b43f0b');
insert into enrolment(employee_id,programme_id) values ('0cef81ba-74bd-4731-8884-b45964a30e86','dd00b69f-1f15-4ec5-b66c-c70f94b43f0b');