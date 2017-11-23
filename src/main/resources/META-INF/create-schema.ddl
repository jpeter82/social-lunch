create table addresses (id  serial not null, address_line varchar(255), alias varchar(255), city varchar(255), country varchar(255), zip varchar(255), primary key (id))
create table events (id  bigserial not null, capacity int4, created timestamp, date timestamp, description varchar(255), picture varchar(255), title varchar(255), address_id int4, host_id int8, primary key (id))
create table events_tags (Event_id int8 not null, tagList_id int4 not null)
create table reservations (id  bigserial not null, created timestamp, event_id int8, user_id int8, primary key (id))
create table reviews (id  serial not null, created date, rating int4 not null, event_id int8, giver_id int8, receiver_id int8, primary key (id))
create table tags (id  serial not null, created timestamp, tag_name varchar(255) not null, primary key (id))
create table tags_events (Tag_id int4 not null, events_id int8 not null)
create table users (id  bigserial not null, created timestamp, email varchar(255) not null, first_name varchar(255), image_file_name varchar(255), is_active smallint default 1, is_admin smallint default 0, last_name varchar(255), modified timestamp, password varchar(255), phone varchar(255), primary key (id))
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table events add constraint FKquc7xx27bo60lupj2rf7e0hn2 foreign key (address_id) references addresses
alter table events add constraint FKnsvyk08eqkdlxp4d2httg2u8v foreign key (host_id) references users
alter table events_tags add constraint FKtpwh6ecs2g7nn79y1hpcyk791 foreign key (tagList_id) references tags
alter table events_tags add constraint FKsw82fnlx6uwewu9ih7q62n64d foreign key (Event_id) references events
alter table reservations add constraint FKcnr8finplwp8whntrr02jpvre foreign key (event_id) references events
alter table reservations add constraint FKb5g9io5h54iwl2inkno50ppln foreign key (user_id) references users
alter table reviews add constraint FKem6jjo18jyueiqhferf3dwfbx foreign key (event_id) references events
alter table reviews add constraint FKa1o9mvhnvvb70ad2x53aduio9 foreign key (giver_id) references users
alter table reviews add constraint FK77qnqsbwjkgvrto39r56vv03b foreign key (receiver_id) references users
alter table tags_events add constraint FKphnsr05f6oc0048se9lqdt10m foreign key (events_id) references events
alter table tags_events add constraint FKo8fo4gn116q3iysm4a4xlmuk8 foreign key (Tag_id) references tags
create table addresses (id  serial not null, address_line varchar(255), alias varchar(255), city varchar(255), country varchar(255), zip varchar(255), primary key (id))
create table events (id  bigserial not null, capacity int4, created timestamp, date timestamp, description varchar(255), picture varchar(255), title varchar(255), address_id int4, host_id int8, primary key (id))
create table events_tags (Event_id int8 not null, tagList_id int4 not null)
create table reservations (id  bigserial not null, created timestamp, event_id int8, user_id int8, primary key (id))
create table reviews (id  serial not null, created date, rating int4 not null, event_id int8, giver_id int8, receiver_id int8, primary key (id))
create table tags (id  serial not null, created timestamp, tag_name varchar(255) not null, primary key (id))
create table tags_events (Tag_id int4 not null, events_id int8 not null)
create table users (id  bigserial not null, created timestamp, email varchar(255) not null, first_name varchar(255), image_file_name varchar(255), is_active smallint default 1, is_admin smallint default 0, last_name varchar(255), modified timestamp, password varchar(255), phone varchar(255), primary key (id))
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table events add constraint FKquc7xx27bo60lupj2rf7e0hn2 foreign key (address_id) references addresses
alter table events add constraint FKnsvyk08eqkdlxp4d2httg2u8v foreign key (host_id) references users
alter table events_tags add constraint FKtpwh6ecs2g7nn79y1hpcyk791 foreign key (tagList_id) references tags
alter table events_tags add constraint FKsw82fnlx6uwewu9ih7q62n64d foreign key (Event_id) references events
alter table reservations add constraint FKcnr8finplwp8whntrr02jpvre foreign key (event_id) references events
alter table reservations add constraint FKb5g9io5h54iwl2inkno50ppln foreign key (user_id) references users
alter table reviews add constraint FKem6jjo18jyueiqhferf3dwfbx foreign key (event_id) references events
alter table reviews add constraint FKa1o9mvhnvvb70ad2x53aduio9 foreign key (giver_id) references users
alter table reviews add constraint FK77qnqsbwjkgvrto39r56vv03b foreign key (receiver_id) references users
alter table tags_events add constraint FKphnsr05f6oc0048se9lqdt10m foreign key (events_id) references events
alter table tags_events add constraint FKo8fo4gn116q3iysm4a4xlmuk8 foreign key (Tag_id) references tags
create table addresses (id  serial not null, address_line varchar(255), alias varchar(255), city varchar(255), country varchar(255), zip varchar(255), primary key (id))
create table events (id  bigserial not null, capacity int4, created timestamp, date timestamp, description varchar(255), picture varchar(255), title varchar(255), address_id int4, host_id int8, primary key (id))
create table events_tags (Event_id int8 not null, tagList_id int4 not null)
create table reservations (id  bigserial not null, created timestamp, event_id int8, user_id int8, primary key (id))
create table reviews (id  serial not null, created date, rating int4 not null, event_id int8, giver_id int8, receiver_id int8, primary key (id))
create table tags (id  serial not null, created timestamp, tag_name varchar(255) not null, primary key (id))
create table tags_events (Tag_id int4 not null, events_id int8 not null)
create table users (id  bigserial not null, created timestamp, email varchar(255) not null, first_name varchar(255), image_file_name varchar(255), is_active smallint default 1, is_admin smallint default 0, last_name varchar(255), modified timestamp, password varchar(255), phone varchar(255), primary key (id))
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table events add constraint FKquc7xx27bo60lupj2rf7e0hn2 foreign key (address_id) references addresses
alter table events add constraint FKnsvyk08eqkdlxp4d2httg2u8v foreign key (host_id) references users
alter table events_tags add constraint FKtpwh6ecs2g7nn79y1hpcyk791 foreign key (tagList_id) references tags
alter table events_tags add constraint FKsw82fnlx6uwewu9ih7q62n64d foreign key (Event_id) references events
alter table reservations add constraint FKcnr8finplwp8whntrr02jpvre foreign key (event_id) references events
alter table reservations add constraint FKb5g9io5h54iwl2inkno50ppln foreign key (user_id) references users
alter table reviews add constraint FKem6jjo18jyueiqhferf3dwfbx foreign key (event_id) references events
alter table reviews add constraint FKa1o9mvhnvvb70ad2x53aduio9 foreign key (giver_id) references users
alter table reviews add constraint FK77qnqsbwjkgvrto39r56vv03b foreign key (receiver_id) references users
alter table tags_events add constraint FKphnsr05f6oc0048se9lqdt10m foreign key (events_id) references events
alter table tags_events add constraint FKo8fo4gn116q3iysm4a4xlmuk8 foreign key (Tag_id) references tags
create table addresses (id  serial not null, address_line varchar(255), alias varchar(255), city varchar(255), country varchar(255), zip varchar(255), primary key (id))
create table events (id  bigserial not null, capacity int4, created timestamp, date timestamp, description varchar(255), picture varchar(255), title varchar(255), address_id int4, host_id int8, primary key (id))
create table events_tags (Event_id int8 not null, tagList_id int4 not null)
create table reservations (id  bigserial not null, created timestamp, event_id int8, user_id int8, primary key (id))
create table reviews (id  serial not null, created date, rating int4 not null, event_id int8, giver_id int8, receiver_id int8, primary key (id))
create table tags (id  serial not null, created timestamp, tag_name varchar(255) not null, primary key (id))
create table tags_events (Tag_id int4 not null, events_id int8 not null)
create table users (id  bigserial not null, created timestamp, email varchar(255) not null, first_name varchar(255), image_file_name varchar(255), is_active smallint default 1, is_admin smallint default 0, last_name varchar(255), modified timestamp, password varchar(255), phone varchar(255), primary key (id))
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table events add constraint FKquc7xx27bo60lupj2rf7e0hn2 foreign key (address_id) references addresses
alter table events add constraint FKnsvyk08eqkdlxp4d2httg2u8v foreign key (host_id) references users
alter table events_tags add constraint FKtpwh6ecs2g7nn79y1hpcyk791 foreign key (tagList_id) references tags
alter table events_tags add constraint FKsw82fnlx6uwewu9ih7q62n64d foreign key (Event_id) references events
alter table reservations add constraint FKcnr8finplwp8whntrr02jpvre foreign key (event_id) references events
alter table reservations add constraint FKb5g9io5h54iwl2inkno50ppln foreign key (user_id) references users
alter table reviews add constraint FKem6jjo18jyueiqhferf3dwfbx foreign key (event_id) references events
alter table reviews add constraint FKa1o9mvhnvvb70ad2x53aduio9 foreign key (giver_id) references users
alter table reviews add constraint FK77qnqsbwjkgvrto39r56vv03b foreign key (receiver_id) references users
alter table tags_events add constraint FKphnsr05f6oc0048se9lqdt10m foreign key (events_id) references events
alter table tags_events add constraint FKo8fo4gn116q3iysm4a4xlmuk8 foreign key (Tag_id) references tags
create table addresses (id  serial not null, address_line varchar(255), alias varchar(255), city varchar(255), country varchar(255), zip varchar(255), primary key (id))
create table events (id  bigserial not null, capacity int4, created timestamp, date timestamp, description varchar(255), picture varchar(255), title varchar(255), address_id int4, host_id int8, primary key (id))
create table events_tags (Event_id int8 not null, tagList_id int4 not null)
create table reservations (id  bigserial not null, created timestamp, event_id int8, user_id int8, primary key (id))
create table reviews (id  serial not null, created timestamp, rating int4 not null, event_id int8, giver_id int8, receiver_id int8, primary key (id))
create table tags (id  serial not null, created timestamp, tag_name varchar(255) not null, primary key (id))
create table tags_events (Tag_id int4 not null, events_id int8 not null)
create table users (id  bigserial not null, created timestamp, email varchar(255) not null, first_name varchar(255), image_file_name varchar(255), is_active smallint default 1, is_admin smallint default 0, last_name varchar(255), modified timestamp, password varchar(255), phone varchar(255), primary key (id))
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table events add constraint FKquc7xx27bo60lupj2rf7e0hn2 foreign key (address_id) references addresses
alter table events add constraint FKnsvyk08eqkdlxp4d2httg2u8v foreign key (host_id) references users
alter table events_tags add constraint FKtpwh6ecs2g7nn79y1hpcyk791 foreign key (tagList_id) references tags
alter table events_tags add constraint FKsw82fnlx6uwewu9ih7q62n64d foreign key (Event_id) references events
alter table reservations add constraint FKcnr8finplwp8whntrr02jpvre foreign key (event_id) references events
alter table reservations add constraint FKb5g9io5h54iwl2inkno50ppln foreign key (user_id) references users
alter table reviews add constraint FKem6jjo18jyueiqhferf3dwfbx foreign key (event_id) references events
alter table reviews add constraint FKa1o9mvhnvvb70ad2x53aduio9 foreign key (giver_id) references users
alter table reviews add constraint FK77qnqsbwjkgvrto39r56vv03b foreign key (receiver_id) references users
alter table tags_events add constraint FKphnsr05f6oc0048se9lqdt10m foreign key (events_id) references events
alter table tags_events add constraint FKo8fo4gn116q3iysm4a4xlmuk8 foreign key (Tag_id) references tags
