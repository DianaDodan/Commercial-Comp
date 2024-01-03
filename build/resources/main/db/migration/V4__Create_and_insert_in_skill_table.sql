create table if not exists skill(
    id uuid default random_uuid() primary key,
    name varchar(255) not null
);

insert into skill(id,name) values ('7dd555bf-d9b3-4442-8ca1-4e00f7990b38','Correct PPE');
insert into skill(id,name) values ('93372716-19b9-41ef-8872-287ebbfce27c','Correct positioning of wheel clocks');
insert into skill(id,name) values ('661488fd-cbf0-4f22-a74a-79257115f1ea','Rock ejectors secured');
insert into skill(id,name) values ('4f93de3b-6f91-41de-94f2-f4f192890303','Suitable positioning of jacks');
insert into skill(id,name) values ('5130481f-a31b-4fc1-a3a3-f1983a6d6d60','Components checked for damage');
