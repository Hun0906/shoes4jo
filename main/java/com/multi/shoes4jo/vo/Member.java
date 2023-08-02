package com.multi.shoes4jo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String MemberID; //아이디
	private String MemberName; //이름
	private String MemberPW; //비밀번호
	private String SignUpDate; //가입일

}
