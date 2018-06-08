package model;

import java.util.Date;

public class Board {
	/* Map으로 하실분들은 만들지 않아도 됩니다.*/
	/*
	 글 번호 : 정수, 자동증가(시퀀스 이용) num primary key
	글 제목 : 문자열                                     title varchar2(50) not null
	글쓴이 : 문자열                                      name  varchar2(30) not null
	비밀번호 : 문자열                                   pass   varchar2(50) not null
	이메일 : 문자열                                      email varchar2(50) not null unique
	내용 : 문자열                                         content varchar2(1000)
	조회수 : 정수                                         readCount number(10) 초기값 0 
	게시일 : 날짜                                         writeDate date 초기값 sysdate
		 * */
	private int num;
	private String title;
	private String name;
	private String pass;
	private String email;
	private String content;
	private int readCount;
	private Date writeDate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", name=" + name + ", pass=" + pass + ", email=" + email
				+ ", content=" + content + ", readCount=" + readCount + ", writeDate=" + writeDate + "]";
	}
	
	
	
}
