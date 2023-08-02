package com.multi.shoes4jo.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("MemberVO")
public class MemberVO {
	private String MemberID;
	private String MemberName;
	private String MemberPW;
	private Date SignUpDate;

	public MemberVO() {

	}

	public MemberVO(String id, String MemberName, String Name) {
		this.MemberID = MemberID;
		this.MemberName = MemberName;
		this.MemberPW = MemberPW;
		this.SignUpDate = SignUpDate;
	}

	public String getMemberID() {
		return MemberID;
	}

	public void setMemberID(String MemberID) {
		this.MemberID = MemberID;
	}

	public String getMemberName() {
		return MemberName;
	}

	public void setMemberName(String MemberName) {
		this.MemberName = MemberName;
	}

	public String getMemberPW() {
		return MemberPW;
	}

	public void setMemberPW(String MemberPW) {
		this.MemberPW = MemberPW;
	}

	public Date getSignUpDate() {
		return SignUpDate;
	}

	public void setSignUpDate(Date joinDate) {
		this.SignUpDate = SignUpDate;
	}

}
