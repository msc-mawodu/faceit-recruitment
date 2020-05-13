create table faceit_user.user (
  id int not null primary key,
  forename varchar(64),
  surname varchar(64),
  nickname varchar(64),
  password varchar(64),
  email varchar(64),
  country varchar(64)
);
