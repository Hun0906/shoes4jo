package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("GoodsDetailVO")
public class GoodsDetailVO {

	private String keyword;
	private String thumbnail;
	private String goods_id;
	private String goods_name;
	private String seller_name;
	private String seller_url;
	private int goods_price;
	private int delivery_fee;
	private String goods_img;
	private String update_date;
    private String category;    
    private MultipartFile file;

    
    
	public GoodsDetailVO() {
	}



	
	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getGoods_id() {
		return goods_id;
	}


	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}


	public String getGoods_name() {
		return goods_name;
	}


	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}


	public String getSeller_name() {
		return seller_name;
	}


	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}


	public String getSeller_url() {
		return seller_url;
	}


	public void setSeller_url(String seller_url) {
		this.seller_url = seller_url;
	}


	public int getGoods_price() {
		return goods_price;
	}


	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}


	public int getDelivery_fee() {
		return delivery_fee;
	}


	public void setDelivery_fee(int delivery_fee) {
		this.delivery_fee = delivery_fee;
	}


	public String getGoods_img() {
		return goods_img;
	}


	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}


	public String getUpdate_date() {
		return update_date;
	}


	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	

	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
