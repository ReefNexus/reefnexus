# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coordinate (
  id                        bigint not null,
  latitude                  double,
  longitude                 double,
  constraint pk_coordinate primary key (id))
;

create table fish (
  id                        bigint not null,
  common_name               varchar(255),
  genus                     varchar(255),
  species                   varchar(255),
  scientific                varchar(255),
  family                    varchar(255),
  image                     varchar(255),
  num_added                 bigint,
  constraint pk_fish primary key (id))
;

create table fish_count (
  id                        bigint not null,
  location_id               bigint,
  fish_id                   bigint,
  count                     bigint,
  constraint pk_fish_count primary key (id))
;

create table location (
  id                        bigint not null,
  name                      varchar(255),
  longitude                 double,
  latitude                  double,
  description               varchar(255),
  good_for                  varchar(255),
  image                     varchar(255),
  constraint pk_location primary key (id))
;


create table location_coordinate (
  location_id                    bigint not null,
  coordinate_id                  bigint not null,
  constraint pk_location_coordinate primary key (location_id, coordinate_id))
;

create table location_fish (
  location_id                    bigint not null,
  fish_id                        bigint not null,
  constraint pk_location_fish primary key (location_id, fish_id))
;
create sequence coordinate_seq;

create sequence fish_seq;

create sequence fish_count_seq;

create sequence location_seq;

alter table fish_count add constraint fk_fish_count_location_1 foreign key (location_id) references location (id) on delete restrict on update restrict;
create index ix_fish_count_location_1 on fish_count (location_id);



alter table location_coordinate add constraint fk_location_coordinate_locati_01 foreign key (location_id) references location (id) on delete restrict on update restrict;

alter table location_coordinate add constraint fk_location_coordinate_coordi_02 foreign key (coordinate_id) references coordinate (id) on delete restrict on update restrict;

alter table location_fish add constraint fk_location_fish_location_01 foreign key (location_id) references location (id) on delete restrict on update restrict;

alter table location_fish add constraint fk_location_fish_fish_02 foreign key (fish_id) references fish (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists coordinate;

drop table if exists location_coordinate;

drop table if exists fish;

drop table if exists location_fish;

drop table if exists fish_count;

drop table if exists location;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists coordinate_seq;

drop sequence if exists fish_seq;

drop sequence if exists fish_count_seq;

drop sequence if exists location_seq;

