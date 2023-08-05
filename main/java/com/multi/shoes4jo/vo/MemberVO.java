package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("MemberVO")
public class MemberVO {
	private String member_id;
	private String member_name;
	private String member_pw;
	private String signup_date;
	private String member_email;

	public MemberVO() {

	}

	public MemberVO(String member_id, String member_name, String member_pw, String signup_date) {
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_pw = member_pw;
		this.signup_date = signup_date;
		this.member_email = member_email;
	}

	public String getmember_id() {
		return member_id;
	}

	public void setmember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getmember_name() {
		return member_name;
	}

	public void setmember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getmember_pw() {
		return member_pw;
	}

	public void setmember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getsignup_date() {
		return signup_date;
	}

	public void setsignup_date(String joinDate) {
		this.signup_date = signup_date;
	}
	
	public String getmember_email() {
		return member_email;
	}

	public void setmember_email(String member_email) {
		this.member_email = member_email;
	}
}
