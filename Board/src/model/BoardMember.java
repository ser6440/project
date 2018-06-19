package model;

import java.util.Date;

public class BoardMember {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date reg_date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return reg_date;
	}
	public void setRegDate(Date regDate) {
		this.reg_date = regDate;
	}
	@Override
	public String toString() {
		return "BoardMember [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", regDate=" + reg_date + "]";
	}
	
	
	
}
