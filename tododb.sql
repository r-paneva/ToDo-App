
CREATE DATABASE  IF NOT EXISTS `tododb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `tododb`;

create or replace table if not exists todos
(
  TodoID      int auto_increment
  constraint `PRIMARY`
  primary key,
  Title       varchar(45)             not null,
  Description varchar(256) default '' null,
  Status      tinyint default 1       null
);
