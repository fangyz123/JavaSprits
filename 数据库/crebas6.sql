/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/4 15:53:40                           */
/*==============================================================*/


drop table if exists class_administration;

drop table if exists class_course;

drop table if exists course;

drop table if exists leave_paper;

drop table if exists load_student;

drop table if exists load_teacher;

drop table if exists record;

drop table if exists student_class;

drop table if exists students;

drop table if exists teacher;

drop table if exists times;

/*==============================================================*/
/* Table: class_administration                                  */
/*==============================================================*/
create table class_administration
(
   c_a_id               int not null,
   name                 varchar(20),
   primary key (c_a_id)
);

/*==============================================================*/
/* Table: class_course                                          */
/*==============================================================*/
create table class_course
(
   class_id             int not null,
   class_name           varchar(40),
   tid                  int,
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
/* Table: leave_paper                                           */
/*==============================================================*/
create table leave_paper
(
   id                   int not null,
   sid                  varchar(15),
   apply_time           timestamp,
   img_src              varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: load_student                                          */
/*==============================================================*/
create table load_student
(
   id                   int not null,
   login_time           timestamp,
   sid                  int,
   ip_current           varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: load_teacher                                          */
/*==============================================================*/
create table load_teacher
(
   id                   int not null,
   login_time           timestamp,
   tid                  int,
   current_id           varchar(15),
   primary key (id)
);

/*==============================================================*/
/* Table: record                                                */
/*==============================================================*/
create table record
(
   id                   int not null,
   sid                  int,
   state                int,
   date                 date,
   course_id            int,
   primary key (id)
);

/*==============================================================*/
/* Table: student_class                                         */
/*==============================================================*/
create table student_class
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
   ip                   varchar(20),
   c_a_id               int,
   primary key (sid)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   tid                  int not null,
   password             varchar(30),
   state                int,
   tname                varchar(15),
   ip                   varchar(20),
   primary key (tid)
);

/*==============================================================*/
/* Table: times                                                 */
/*==============================================================*/
create table times
(
   id                   int not null,
   c_week               varchar(20),
   c_date               varchar(20),
   c_time               varchar(30),
   class_id             int,
   primary key (id)
);

