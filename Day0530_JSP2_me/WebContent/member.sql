create table member(
	id varchar2(20) primary key,
	pw varchar2(20) not null,
	name varchar2(20) not null,
	email varachar2(20) not null,
	regDate date default sysdate
)
