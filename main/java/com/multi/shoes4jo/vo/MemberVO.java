package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("MemberVO")
public class MemberVO {
	private String MemberID;
	private String MemberName;
	private String MemberPW;
	private String SignUpDate;

	public MemberVO() {

	}

	public MemberVO(String MemberID, String MemberName, String MemberPW, String SignUpDate) {
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

	public String getSignUpDate() {
		return SignUpDate;
	}

	public void setSignUpDate(String joinDate) {
		this.SignUpDate = SignUpDate;
	}

}
