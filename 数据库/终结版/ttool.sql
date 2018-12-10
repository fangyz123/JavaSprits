/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/10 8:39:32                           */
/*==============================================================*/


drop table if exists classAdministration;

drop table if exists classCourse;

drop table if exists course;

drop table if exists leavePaper;

drop table if exists loadStudent;

drop table if exists loadTeacher;

drop table if exists manager;

drop table if exists nodeNumber;

drop table if exists record;

drop table if exists studentClass;

drop table if exists students;

drop table if exists teacher;

drop table if exists term;

drop table if exists times;

/*==============================================================*/
/* Table: classAdministration                                   */
/*==============================================================*/
create table classAdministration
(
   c_a_id               int not null,
   name                 varchar(20),
   primary key (c_a_id)
);

/*==============================================================*/
/* Table: classCourse                                           */
/*==============================================================*/
create table classCourse
(
   class_id             int not null,
   class_name           varchar(40),
   tid                  varchar(15),
   course_id            int,
   primary key (class_id)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   course_id            int not null,
   cname                varchar(50),
   primary key (course_id)
);

/*==============================================================*/
/* Table: leavePaper                                            */
/*==============================================================*/
create table leavePaper
(
   id                   int not null,
   sid                  varchar(15),
   apply_time           timestamp,
   img_src              varchar(40),
   status               int,
   primary key (id)
);

/*==============================================================*/
/* Table: loadStudent                                           */
/*==============================================================*/
create table loadStudent
(
   id                   int not null,
   login_time           timestamp,
   sid                  varchar(15),
   primary key (id)
);

/*==============================================================*/
/* Table: loadTeacher                                           */
/*==============================================================*/
create table loadTeacher
(
   id                   int not null,
   login_time           timestamp,
   tid                  varchar(15),
   primary key (id)
);

/*==============================================================*/
/* Table: manager                                               */
/*==============================================================*/
create table manager
(
   m_id                 varchar(15) not null,
   password             varchar(25),
   primary key (m_id)
);

/*==============================================================*/
/* Table: nodeNumber                                            */
/*==============================================================*/
create table nodeNumber
(
   node_id              int not null,
   node                 varchar(10),
   node_time            varchar(30),
   sign_range           int,
   primary key (node_id)
);

/*==============================================================*/
/* Table: record                                                */
/*==============================================================*/
create table record
(
   id                   int not null,
   sid                  varchar(15),
   state                int,
   date                 timestamp,
   course_id            int,
   primary key (id)
);

/*==============================================================*/
/* Table: studentClass                                          */
/*==============================================================*/
create table studentClass
(
   id                   int not null,
   class_id             int,
   sid                  varchar(15),
   primary key (id)
);

/*==============================================================*/
/* Table: students                                              */
/*==============================================================*/
create table students
(
   sid                  varchar(15) not null,
   password             varchar(30),
   state                int,
   name                 varchar(10),
   c_a_id               int,
   ip                   varchar(20),
   primary key (sid)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   tid                  varchar(15) not null,
   password             varchar(30),
   state                int,
   tname                varchar(15),
   ip                   varchar(20),
   primary key (tid)
);

/*==============================================================*/
/* Table: term                                                  */
/*==============================================================*/
create table term
(
   term_id              int not null,
   time_begin           timestamp,
   time_end             timestamp,
   status               int,
   primary key (term_id)
);

/*==============================================================*/
/* Table: times                                                 */
/*==============================================================*/
create table times
(
   id                   int not null,
   c_week               varchar(20),
   c_date               varchar(20),
   node_id              int,
   class_id             int,
   primary key (id)
);

