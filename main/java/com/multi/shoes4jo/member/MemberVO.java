package com.multi.shoes4jo.member;

import org.springframework.stereotype.Component;


@Component("MemberVO")
public class MemberVO {
	private String member_id;
	private String member_name;
	private String member_pw;
	private String signup_date;
	private String member_email;
	private String member_phone;
 
	public MemberVO() {

	}

	public MemberVO(String member_id, String member_name, String member_pw, String signup_date, String member_email,
			String member_phone) {
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_pw = member_pw;
		this.signup_date = signup_date;
		this.member_email = member_email;
		this.member_phone = member_phone;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(String signup_date) {
		this.signup_date = signup_date;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	
} 
