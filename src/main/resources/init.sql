create table role
(
    id            bigint    not null
        constraint role_pk
            primary key,
    creation_time timestamp not null,
    is_relevant   boolean   not null,
    name          varchar,
    description   varchar
);

alter table role
    owner to postgres;

create unique index role_id_uindex
    on role (id);

