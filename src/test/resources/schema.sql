drop table if exists car CASCADE;
drop table if exists driver CASCADE;
 
 create table driver
(
   `id` bigint not null,
   `feet` double,
   `hands` double,
   primary key (id)
);
 
 create table car
(
   id bigint not null,
   cost integer not null,
   make varchar (255),
   plate_number varchar (255),
   wheels integer not null,
   driver_id bigint,
   primary key (id)
);


alter table car add constraint FKt075681k23ii3uvdxjvvmmpm foreign key (driver_id) references driver on delete cascade;