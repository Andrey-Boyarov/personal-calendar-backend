CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table dict_role
(
    id            bigint                          not null
        constraint role_pk
            primary key,
    creation_time timestamp                       not null,
    is_relevant   boolean                         not null,
    name          varchar,
    description   varchar,
    uuid          uuid default uuid_generate_v4() not null
);

alter table dict_role
    owner to postgres;

create unique index role_id_uindex
    on dict_role (id);

create unique index dict_role_uuid_uindex
    on dict_role (uuid);

