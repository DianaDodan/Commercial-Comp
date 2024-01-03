create type proficiency_level as enum(1,2,3,4,5);

create table if not exists proficiency(
    employee_id uuid not null,
    foreign key (employee_id) references employee(id),
    skill_id uuid not null,
    foreign key (skill_id) references skill(id),
    primary key(employee_id,skill_id),
    proficiency proficiency_level not null default 1
);

insert into proficiency(employee_id,skill_id) values ('ee49ea95-ccce-4154-8180-4624de47d3bd','7dd555bf-d9b3-4442-8ca1-4e00f7990b38');
insert into proficiency(employee_id,skill_id) values ('ee49ea95-ccce-4154-8180-4624de47d3bd','93372716-19b9-41ef-8872-287ebbfce27c');
insert into proficiency(employee_id,skill_id) values ('ee49ea95-ccce-4154-8180-4624de47d3bd','661488fd-cbf0-4f22-a74a-79257115f1ea');
insert into proficiency(employee_id,skill_id) values ('ee49ea95-ccce-4154-8180-4624de47d3bd','4f93de3b-6f91-41de-94f2-f4f192890303');
insert into proficiency(employee_id,skill_id) values ('ee49ea95-ccce-4154-8180-4624de47d3bd','5130481f-a31b-4fc1-a3a3-f1983a6d6d60');

insert into proficiency(employee_id,skill_id) values ('3147fc12-3b98-41e7-84a7-342f65eb9a04','7dd555bf-d9b3-4442-8ca1-4e00f7990b38');
insert into proficiency(employee_id,skill_id) values ('3147fc12-3b98-41e7-84a7-342f65eb9a04','93372716-19b9-41ef-8872-287ebbfce27c');
insert into proficiency(employee_id,skill_id) values ('3147fc12-3b98-41e7-84a7-342f65eb9a04','661488fd-cbf0-4f22-a74a-79257115f1ea');
insert into proficiency(employee_id,skill_id) values ('3147fc12-3b98-41e7-84a7-342f65eb9a04','4f93de3b-6f91-41de-94f2-f4f192890303');
insert into proficiency(employee_id,skill_id) values ('3147fc12-3b98-41e7-84a7-342f65eb9a04','5130481f-a31b-4fc1-a3a3-f1983a6d6d60');

insert into proficiency(employee_id,skill_id) values ('0cef81ba-74bd-4731-8884-b45964a30e86','7dd555bf-d9b3-4442-8ca1-4e00f7990b38');
insert into proficiency(employee_id,skill_id) values ('0cef81ba-74bd-4731-8884-b45964a30e86','93372716-19b9-41ef-8872-287ebbfce27c');
insert into proficiency(employee_id,skill_id) values ('0cef81ba-74bd-4731-8884-b45964a30e86','661488fd-cbf0-4f22-a74a-79257115f1ea');
insert into proficiency(employee_id,skill_id) values ('0cef81ba-74bd-4731-8884-b45964a30e86','4f93de3b-6f91-41de-94f2-f4f192890303');
insert into proficiency(employee_id,skill_id) values ('0cef81ba-74bd-4731-8884-b45964a30e86','5130481f-a31b-4fc1-a3a3-f1983a6d6d60');