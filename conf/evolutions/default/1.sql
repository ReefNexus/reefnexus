# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email))
;

create table coordinate (
  id                        bigint not null,
  latitude                  float,
  longitude                 float,
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

create table location (
  id                        bigint not null,
  name                      varchar(255),
  longitude                 float,
  latitude                  float,
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
create sequence account_seq;

create sequence coordinate_seq;

create sequence fish_seq;

create sequence location_seq;




alter table location_coordinate add constraint fk_location_coordinate_locati_01 foreign key (location_id) references location (id);

alter table location_coordinate add constraint fk_location_coordinate_coordi_02 foreign key (coordinate_id) references coordinate (id);

alter table location_fish add constraint fk_location_fish_location_01 foreign key (location_id) references location (id);

alter table location_fish add constraint fk_location_fish_fish_02 foreign key (fish_id) references fish (id);

# --- !Downs

drop table if exists account cascade;

drop table if exists coordinate cascade;

drop table if exists location_coordinate cascade;

drop table if exists fish cascade;

drop table if exists location_fish cascade;

drop table if exists location cascade;

drop sequence if exists account_seq;

drop sequence if exists coordinate_seq;

drop sequence if exists fish_seq;

drop sequence if exists location_seq;

