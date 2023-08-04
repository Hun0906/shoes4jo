package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkK {
		private int BookMarkID;
		private String MemberID;
		private String StartDate;
		private String EndDate;
		private String TimeUnit;
		private String Keywords;
		private String Device;
		private String Gender;
		private String Ages;
		private String AddDate;
	}

