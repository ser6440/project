
create table member(
	id varchar2(20) primary key,
	pw varchar2(50) not null,
	name varchar2(20) not null,
	email varchar2(30) unique not null,
	reg_date date default sysdate
);




