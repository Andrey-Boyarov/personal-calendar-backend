create table dict_role
(
    id            bigserial                          not null
        constraint role_pk
            primary key,
    creation_time timestamp                          not null,
    is_relevant   boolean default true               not null,
    name          varchar,
    description   varchar,
    uuid          uuid    default uuid_generate_v4() not null
);

alter table dict_role
    owner to postgres;

create unique index role_id_uindex
    on dict_role (id);

create unique index dict_role_uuid_uindex
    on dict_role (uuid);

create table ent_user
(
    id               bigserial                              not null
        constraint ent_user_pk
            primary key,
    creation_time    timestamp                              not null,
    is_relevant      boolean default true                   not null,
    uuid             uuid    default uuid_generate_v4()     not null,
    login            varchar                                not null,
    is_banned_until  timestamp,
    mail_address     varchar,
    irrelevant_until timestamp,
    password         varchar default 'l'::character varying not null
);

alter table ent_user
    owner to postgres;

create unique index ent_user_id_uindex
    on ent_user (id);

create unique index ent_user_uuid_uindex
    on ent_user (uuid);

create unique index ent_user_login_uindex
    on ent_user (login);

create table ent_subscription
(
    id            bigserial                          not null
        constraint ent_subscription_pk
            primary key,
    creation_time timestamp                          not null,
    is_relevant   boolean default true               not null,
    uuid          uuid    default uuid_generate_v4() not null,
    user_ref      bigint
        constraint ent_subscription_user_ref_fkey
            references ent_user,
    target_ref    bigint
        constraint target_ref_fkey
            references ent_user
);

alter table ent_subscription
    owner to postgres;

create unique index ent_subscription_id_uindex
    on ent_subscription (id);

create unique index ent_subscription_uuid_uindex
    on ent_subscription (uuid);

create table ent_event
(
    id               bigserial                          not null
        constraint ent_event_pk
            primary key,
    creation_time    timestamp                          not null,
    is_relevant      boolean default true               not null,
    uuid             uuid    default uuid_generate_v4() not null,
    irrelevant_until timestamp,
    start_date_time  timestamp                          not null,
    end_date_time    timestamp                          not null,
    title            varchar,
    maintain         varchar,
    meta_references  varchar,
    author           bigint
        constraint ent_event_author_fkey
            references ent_user,
    is_public        boolean default false
);

alter table ent_event
    owner to postgres;

create unique index ent_event_id_uindex
    on ent_event (id);

create unique index ent_event_uuid_uindex
    on ent_event (uuid);

create table user_role_link
(
    id            bigserial                          not null
        constraint role_link_pk
            primary key,
    creation_time timestamp                          not null,
    is_relevant   boolean default true               not null,
    uuid          uuid    default uuid_generate_v4() not null,
    user_ref      bigint                             not null,
    role_ref      bigint                             not null
);

alter table user_role_link
    owner to postgres;

create unique index role_link_id_uindex
    on user_role_link (id);

create unique index user_role_link_uuid_uindex
    on user_role_link (uuid);

create function uuid_nil() returns uuid
    immutable
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_nil() owner to postgres;

create function uuid_ns_dns() returns uuid
    immutable
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_ns_dns() owner to postgres;

create function uuid_ns_url() returns uuid
    immutable
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_ns_url() owner to postgres;

create function uuid_ns_oid() returns uuid
    immutable
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_ns_oid() owner to postgres;

create function uuid_ns_x500() returns uuid
    immutable
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_ns_x500() owner to postgres;

create function uuid_generate_v1() returns uuid
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_generate_v1() owner to postgres;

create function uuid_generate_v1mc() returns uuid
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_generate_v1mc() owner to postgres;

create function uuid_generate_v3(namespace uuid, name text) returns uuid
    immutable
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_generate_v3(uuid, text) owner to postgres;

create function uuid_generate_v4() returns uuid
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_generate_v4() owner to postgres;

create function uuid_generate_v5(namespace uuid, name text) returns uuid
    immutable
    strict
    parallel safe
    language c
as
$$
begin
-- missing source code
end;
$$;

alter function uuid_generate_v5(uuid, text) owner to postgres;

