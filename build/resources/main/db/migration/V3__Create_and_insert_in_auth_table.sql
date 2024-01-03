create table if not exists auth(
    username varchar(255) not null primary key,
    password varchar(255) not null,
    salt varchar(255) not null
);

insert into auth (username, password, salt) values ('tony', '$2a$10$b1oDMgma9OkDY51QaD35u./3OyzH6kpwJBgRRndkb9rS6iw8UmR2m', '/sRGPz35ZXKzHDukeM7Klw==')