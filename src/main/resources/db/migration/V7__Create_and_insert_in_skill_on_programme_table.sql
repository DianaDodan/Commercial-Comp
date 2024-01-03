create table if not exists skill_on_programme(
    programme_id uuid not null,
    foreign key (programme_id) references programme(id),
    skill_id uuid not null,
    foreign key (skill_id) references skill(id),
    primary key(programme_id,skill_id)
);

insert into skill_on_programme(programme_id,skill_id) values ('dd00b69f-1f15-4ec5-b66c-c70f94b43f0b','7dd555bf-d9b3-4442-8ca1-4e00f7990b38');
insert into skill_on_programme(programme_id,skill_id) values ('dd00b69f-1f15-4ec5-b66c-c70f94b43f0b','93372716-19b9-41ef-8872-287ebbfce27c');
insert into skill_on_programme(programme_id,skill_id) values ('dd00b69f-1f15-4ec5-b66c-c70f94b43f0b','661488fd-cbf0-4f22-a74a-79257115f1ea');
insert into skill_on_programme(programme_id,skill_id) values ('dd00b69f-1f15-4ec5-b66c-c70f94b43f0b','4f93de3b-6f91-41de-94f2-f4f192890303');
insert into skill_on_programme(programme_id,skill_id) values ('dd00b69f-1f15-4ec5-b66c-c70f94b43f0b','5130481f-a31b-4fc1-a3a3-f1983a6d6d60');