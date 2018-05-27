package com.bmpl.crud.dto;

//import java.util.ResourceBundle;

public class ProductDTO {
	private String name;
	private String desc;
	private String price;
	private String id;
	public ProductDTO(){
		
	}
	public ProductDTO(String name, String desc, String price, String id){
		//ResourceBundle rb = ResourceBundle.getBundle("config");
		//String imagePath = rb.getString("imagepath");
		this.name= name;
		this.desc= desc;
		this.price= price;
		this.id= id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
