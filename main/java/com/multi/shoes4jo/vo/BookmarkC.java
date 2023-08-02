package com.multi.shoes4jo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkC {
	private int BookMarkID;
	private String MemberID;
	private String StartDate;
	private String EndDate;
	private String TimeUnit;
	private String Category;
	private String CategoryName;
	private String CategoryParam;
	private String Device;
	private String Gender;
	private String Ages;
	private String AddDate;
}