INSERT INTO public.ent_user (id, creation_time, is_relevant, uuid, login, is_banned_until, mail_address, irrelevant_until, password) VALUES (1, '2022-03-18 21:24:10.000000', true, default , 'root', null, 'test@gmail.com', null, '$2a$10$MUnMaJV/3gtFw74W2qjvLeTz45gbN8KnlOwJZeAmmcOFSeqB3Fwv.');

INSERT INTO public.dict_role (id, creation_time, is_relevant, name, description, uuid) VALUES (1, '2022-03-18 21:24:48.000000', true, 'consumer', 'user can see schedules', default );
INSERT INTO public.dict_role (id, creation_time, is_relevant, name, description, uuid) VALUES (2, '2022-03-27 18:21:31.000000', true, 'creator', 'user can schedule', default );
INSERT INTO public.dict_role (id, creation_time, is_relevant, name, description, uuid) VALUES (3, '2022-03-27 18:21:34.000000', true, 'admin', 'user is admin of the system', default );

INSERT INTO public.ent_event (id, creation_time, is_relevant, uuid, irrelevant_until, start_date_time, end_date_time, title, maintain, meta_references, author, is_public) VALUES (1, '2022-03-28 13:12:28.000000', true, default , null, '2022-03-28 13:12:35.000000', '2022-03-28 14:12:38.000000', 'Some test event', 'Some main text, yeah, that example is gorgeous', 'google.com', 1, false);

INSERT INTO public.user_role_link (id, creation_time, is_relevant, uuid, user_ref, role_ref) VALUES (1, '2022-03-27 18:23:58.000000', true, default, 1, 1);

INSERT INTO public.ent_subscription (id, creation_time, is_relevant, uuid, user_ref, target_ref)
VALUES (DEFAULT, '2022-03-28 13:17:23.000000', DEFAULT, DEFAULT, 1, 1);

