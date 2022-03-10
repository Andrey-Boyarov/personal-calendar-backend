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

create table ent_user
(
    id            bigint                          not null
        constraint ent_user_pk
            primary key,
    creation_time timestamp                       not null,
    is_relevant   boolean                         not null,
    uuid          uuid default uuid_generate_v4() not null,
    login varchar not null,
    role bigint,
    foreign key (role) references dict_role(id),
    is_banned_until timestamp,
    mail_address varchar,
    irrelevant_until timestamp
);

alter table ent_user
    owner to postgres;

create unique index ent_user_id_uindex
    on ent_user (id);

create unique index ent_user_uuid_uindex
    on ent_user (uuid);

create table meta_password
(
    id            bigint                          not null
        constraint meta_password_pk
            primary key,
    creation_time timestamp                       not null,
    is_relevant   boolean                         not null,
    name          varchar,
    description   varchar,
    uuid          uuid default uuid_generate_v4() not null,
    user_ref bigint,
    foreign key (user_ref) references ent_user(id),
    password varchar not null
);

alter table meta_password
    owner to postgres;

create unique index meta_password_id_uindex
    on meta_password (id);

create unique index meta_password_uuid_uindex
    on meta_password (uuid);

create table ent_event
(
    id               bigint                          not null
        constraint ent_event_pk
            primary key,
    creation_time    timestamp                       not null,
    is_relevant      boolean                         not null,
    uuid             uuid default uuid_generate_v4() not null,
    irrelevant_until timestamp,
    start_date_time timestamp not null,
    end_date_time timestamp not null,
    title varchar,
    maintain varchar,
    meta_references varchar
);

alter table ent_event
    owner to postgres;

create unique index ent_event_id_uindex
    on ent_event (id);

create unique index ent_event_uuid_uindex
    on ent_event (uuid);

create table ent_subscription
(
    id            bigint                          not null
        constraint ent_subscription_pk
            primary key,
    creation_time timestamp                       not null,
    is_relevant   boolean                         not null,
    name          varchar,
    description   varchar,
    uuid          uuid default uuid_generate_v4() not null,
    user_ref      bigint
        constraint ent_subscription_user_ref_fkey
            references ent_user,
    target_ref bigint constraint target_ref_fkey references ent_user
);

alter table ent_subscription
    owner to postgres;

create unique index ent_subscription_id_uindex
    on ent_subscription (id);

create unique index ent_subscription_uuid_uindex
    on ent_subscription (uuid);

