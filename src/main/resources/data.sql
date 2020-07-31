/* CREATE statements are Used only in JDBC to Create tables, 
 * But JPA automatically creates TABLE USING THE DEFINED ENTITY
create table user_person (
	id integer primary key,
	name varchar(50) not null,
	user_id varchar(50) not null unique,
	password varchar(50) not null,
	email_id varchar(50) unique not null,
	phone_no integer unique,
	birth_date date
);
*/
/*
create table todo_list (
	uid integer references user_person(id),
	detail varchar(500) not null,
	start_date timestamp not null,
	due_date timestamp,
	priority varchar(30) not null,
	place varchar(50),
	todo_title varchar(50) not null,
	est_time varchar(50),
	todo_id integer primary key
);
*/
insert into person(id, name, user_id, password, email_id, phone_no, birth_date, enabled, role) 
values(10001, 'Ramachandran', 'ramachandran2000', '12345', 'ramachandran2000@gmail.com', '1234567890', '2000-01-01', true, 'USER');

insert into person(id, name, user_id, password, email_id, phone_no, birth_date, enabled, role) 
values(10002, 'Renushika', 'renushika2001', '12345', 'renushika2001@gmail.com', '1234563890', '2001-01-01', true, 'USER');

insert into person(id, name, user_id, password, email_id, phone_no, birth_date, enabled, role) 
values(10003, 'Goku', 'gokul2002', '12345', 'gokul2002@gmail.com', '1234567891', '2002-01-01', true, 'USER');

insert into person(id, name, user_id, password, email_id, phone_no, birth_date, enabled, role) 
values(10004, 'Kadhir', 'kadhir2003', '12345', 'ram2003@gmail.com', '1234517890', '2003-01-01', true, 'USER');

insert into person(id, name, user_id, password, email_id, phone_no, birth_date, enabled, role) 
values(10005, 'Sathya Harini', 'sathya2004', '12345', 'sathya.harini2004@gmail.com', '1134567890', '2004-01-01', true, 'USER');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100001, 10001, 'Learn Django', '2020-07-01', '2020-08-20', 'High', 'Learn Django - how to connect with database, how to use templates, etc..', 'Vellore', '3 Weeks');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100002, 10001, 'Study React', '2020-06-15', '2020-08-20', 'High', 'Try to study React as much as possible', 'Vellore', '2 Weeks');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100003, 10001, 'Learn MongoDB for Python', '2020-06-27', '2020-08-20', 'High', 'MongoDB will be helpful to build robust applications using Django, so study for it', 'Vellore', '1 Week');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100004, 10001, 'Prepare SQL', '2020-07-20', '2020-08-20', 'Medium', 'Revise SQL concepts', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100005, 10002,'Cooking Class', '2020-07-20', '2020-08-20', 'Medium', 'Learn to cook South Indian, North Indian, Chinese food varities', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100006, 10003, 'Practice Trumpet', '2020-07-20', '2020-08-20', 'Low', 'For Marching Band, learn National Anthem', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100007, 10003, 'Dance Practice', '2020-07-20', '2020-08-20', 'Medium', 'Since Annual day is on 20-08-2020, practice dance', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100008, 10003, 'Learn Piano', '2020-07-20', '2020-08-20', 'Low', 'Learn Low pitch tunes', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100009, 10003, 'Car Driving Class', '2020-07-20', '2020-08-20', 'High', 'Driving test is on 22-08-2020, before that try to learn Car driving', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100010, 10004, 'Practice for Spell Bee', '2020-07-20', '2020-08-20', 'High', 'Learn all the words from the Dictionary, because that is the best source containing almost all the words. Also, use google translator to learn pronunciation.', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100011, 10004, 'Typewriting Class', '2020-07-20', '2020-08-20', 'High', 'To have good practice of keyboard typing and also for fast typing', 'Vellore', '2 days');

insert into todo_list(todo_id,user_id,todo_title,start_date,due_date,priority,detail,place,est_time)
values(100012, 10004, 'Special Class', '2020-07-20', '2020-08-20', 'High', 'Since board exams are coming, school scheduled special class from 6-8 pm everyday', 'Vellore', '2 days');
