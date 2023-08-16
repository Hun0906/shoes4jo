package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

//DTO,VO는 각 계층(Layer)간 데이터 교환을 위한 객체(Java Beans)
//로직이 없는 순수한 데이터 객체이며, getter/setter 메소드만을 갖는다.
//@Component("MemberVO")으로 빈 생성함

@Component("MemberVO")
public class MemberVO {
	private String member_id;
	private String member_name;
	private String member_pw;
	private String signup_date;
	private String member_email;
	private String member_phone;
	private String admin_check;
 
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
		this.admin_check = admin_check;
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

	public void setsignup_date(String signup_date) {
		this.signup_date = signup_date;
	}

	public String getmember_email() {
		return member_email;
	}

	public void setmember_email(String member_email) {
		this.member_email = member_email;
	}
	
	public String getmember_phone() {
		return member_phone;
	}

	public void setmember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	
	public String getadmin_check() {
		return admin_check;
	}

	public void setadmin_check(String admin_check) {
		this.admin_check = admin_check;
	}
}
