package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("SnsVO")
public class SnsVO {

	private String sns_id;
	private String sns_type;
	private String sns_name;	
	private String sns_profile;
	private String sns_connect_date;

	public SnsVO() {
	}

	public SnsVO(String sns_id, String sns_type, String sns_name, String sns_profile, String sns_connect_date) {

		this.sns_id = sns_id;
		this.sns_type = sns_type;
		this.sns_name = sns_name;
		this.sns_profile = sns_profile;
		this.sns_connect_date = sns_connect_date;
	}


	public String getSns_id() {
		return sns_id;
	}

	public void setSns_id(String sns_id) {
		this.sns_id = sns_id;
	}

	public String getSns_type() {
		return sns_type;
	}

	public void setSns_type(String sns_type) {
		this.sns_type = sns_type;
	}

	public String getSns_name() {
		return sns_name;
	}

	public void setSns_name(String sns_name) {
		this.sns_name = sns_name;
	}

	public String getSns_profile() {
		return sns_profile;
	}

	public void setSns_profile(String sns_profile) {
		this.sns_profile = sns_profile;
	}

	public String getSns_connect_date() {
		return sns_connect_date;
	}

	public void setSns_connect_date(String sns_connect_date) {
		this.sns_connect_date = sns_connect_date;
	}

}
