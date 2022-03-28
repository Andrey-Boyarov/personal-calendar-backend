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
    meta_references varchar,
    author bigint,
    foreign key (author) references ent_user(id),
    is_public boolean default false
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

create sequence ent_user_id_seq;

alter table ent_user alter column id set default nextval('public.ent_user_id_seq');

alter sequence ent_user_id_seq owned by ent_user.id;

create sequence meta_password_id_seq;

alter table meta_password alter column id set default nextval('public.meta_password_id_seq');

alter sequence meta_password_id_seq owned by meta_password.id;

create sequence ent_subscription_id_seq;

alter table ent_subscription alter column id set default nextval('public.ent_subscription_id_seq');

alter sequence ent_subscription_id_seq owned by ent_subscription.id;

create sequence ent_event_id_seq;

alter table ent_event alter column id set default nextval('public.ent_event_id_seq');

alter sequence ent_event_id_seq owned by ent_event.id;

create sequence dict_role_id_seq;

alter table dict_role alter column id set default nextval('public.dict_role_id_seq');

alter sequence dict_role_id_seq owned by dict_role.id;

alter table meta_password drop column name;

alter table meta_password drop column description;

alter table meta_password alter column is_relevant set default true;

alter table ent_user alter column is_relevant set default true;

alter table ent_subscription alter column is_relevant set default true;

alter table ent_event alter column is_relevant set default true;

alter table dict_role alter column is_relevant set default true;

alter table ent_subscription drop column name;

alter table ent_subscription drop column description;

create unique index ent_user_login_uindex
    on ent_user (login);

alter table ent_user drop constraint ent_user_role_fkey;

alter table ent_user drop column role;

alter table ent_user
    add constraint ent_user_role_fkey
        foreign key (role) references dict_role;

create table user_role_link
(
    id            bigserial                          not null
        constraint role_link_pk
            primary key,
    creation_time timestamp                          not null,
    is_relevant   boolean default true               not null,
    uuid          uuid    default uuid_generate_v4() not null,
    user_ref bigint not null,
    role_ref bigint not null
);

alter table user_role_link
    owner to postgres;

create unique index role_link_id_uindex
    on user_role_link (id);

create unique index user_role_link_uuid_uindex
    on user_role_link (uuid);

drop table meta_password;