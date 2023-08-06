package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkK {
		private int bookmark_id;
		private String member_id;
		private String start_date;
		private String end_date;
		private String time_unit;
		private String keywords;
		private String device;
		private String gender;
		private String ages;
		private String add_date;
	}

