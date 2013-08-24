drop table g1courses;
drop table g1users;
drop table g1courses;
drop table g1students;
drop table g1assigns;

create table g1users(
    u varchar(26) not null primary key,
    p varchar(30) not null,
    t char(1) not null,
    f varchar(25) not null,
    l varchar(25) not null,
    e varchar(40) not null
);


create table g1courses(
    n varchar(100) not null primary key,
    ia varchar(26) not null,
    ib varchar(26)
);

create table g1students(
    n varchar(100) not null,
    u varchar(26) not null
);


create table g1assigns(
    c varchar(100) not null,
    n varchar(100) not null,
    t varchar(100) not null
);

create table g1grades(
    c varchar(100) not null,
    u varchar(26) not null,
    g char(1)
);

insert into g1users(u,p,t,f,l,e) values ('admin','password','a','John','Smith','jsmith@bblite.com');

