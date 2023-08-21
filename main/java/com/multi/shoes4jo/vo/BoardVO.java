package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("BoardVO")
public class BoardVO {

	private int bno;
	private String category;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private String regdate;
	private String file;
	private String filepath;
	private String link;
  
	public BoardVO() {
	}

	public BoardVO(int bno, String category, String title, String content, String writer, int viewcnt, String regdate, String file, String link) {
		this.bno = bno;
		this.category = category;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
		this.file = file;
		this.link = link;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
 
}