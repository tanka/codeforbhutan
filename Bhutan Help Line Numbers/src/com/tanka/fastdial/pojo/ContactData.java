package com.tanka.fastdial.pojo;

public class ContactData {
	String name;
	String number;
	int imgRef;
	public ContactData(String name, String desc, int imgRef){
		this.name = name;
		this.number = desc;
		this.imgRef = imgRef;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String description) {
		this.number = description;
	}
	public int getImgRef() {
		return imgRef;
	}
	public void setImgRef(int imgRef) {
		this.imgRef = imgRef;
	}
}
