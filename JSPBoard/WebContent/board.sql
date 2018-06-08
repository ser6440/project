create table board(
    num number(10) primary key,
    title varchar2(50) not null,
    name varchar2(30) not null,
    pass varchar2(50) not null,
    email varchar2(50) not null,
    content varchar2(1000), 
    readCount number(10) default 0,
    writeDate date default sysdate
);