package study;

import java.time.LocalDateTime;

public class Member {
	private int idx;
	
	private String id;
	private String pw;
	private String name;
	private LocalDateTime registDateTime;
	
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
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public LocalDateTime getRegistDateTime() {
		return registDateTime;
	}
	public void setRegistDateTime(LocalDateTime registDateTime) {
		this.registDateTime = registDateTime;
	}
	
}
