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
	private String update_date;
	private MultipartFile file;
	private int comment_cnt;

	public FreeBoardVO() {
	}

	public FreeBoardVO(int fno, String member_id, String category, String title, String content, int viewcnt,
			String date, String file_name, String file_path, String update_date, MultipartFile file, int comment_cnt) {
		this.fno = fno;
		this.member_id = member_id;
		this.category = category;
		this.title = title;
		this.content = content;
		this.viewcnt = viewcnt;
		this.date = date;
		this.file_name = file_name;
		this.file_path = file_path;
		this.update_date = update_date;
		this.file = file;
		this.comment_cnt = comment_cnt;
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

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getComment_cnt() {
		return comment_cnt;
	}

	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}

}