package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("BoardVO")
public class BoardVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private String regdate;

	public BoardVO() {
		super();
	}

	public BoardVO(int bno, String title, String content, String writer, int viewcnt, String regdate) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
	}

	public int getbno() {
		return bno;
	}

	public void setbno(int bno) {
		this.bno = bno;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getwriter() {
		return writer;
	}

	public void setwriter(String writer) {
		this.writer = writer;
	}

	public int getviewcnt() {
		return viewcnt;
	}

	public void setviewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getregdate() {
		return regdate;
	}

	public void setregdate(String regdate) {
		this.regdate = regdate;
	}

}