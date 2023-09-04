package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("FreeBoardVO")
public class FreeBoardVO {

	private int fno;
	private String member_id;
	private String category;
	private String title;
	private String content;
	private int viewcnt;
	private String date;
	private String file_name;
	private String file_path;
	private String comment;
	private MultipartFile file;

	public FreeBoardVO() {
	}

	public FreeBoardVO(int fno, String member_id, String category, String title, String content, int viewcnt, String date,
			String file_name, String file_path, String comment, MultipartFile file) {
		this.fno = fno;
		this.member_id = member_id;
		this.category = category;
		this.title = title;
		this.content = content;
		this.viewcnt = viewcnt;
		this.date = date;
		this.file_name = file_name;
		this.file_path = file_path;
		this.comment = comment;
		this.file = file;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}