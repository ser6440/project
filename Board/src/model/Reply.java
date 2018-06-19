package model;

import java.util.Date;

public class Reply {
	private int rNum;
	private int bNum;
	private String content;
	private String id;
	private Date writeDate;
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "Reply [rNum=" + rNum + ", bNum=" + bNum + ", content=" + content + ", id=" + id + ", writeDate="
				+ writeDate + "]";
	}
	
	

}
