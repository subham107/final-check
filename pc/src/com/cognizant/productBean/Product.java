package com.cognizant.productBean;

public class Product {
int prod_id;
String category;
String name;
String desc;
String price;
String brand;
String filePath;
int instock;
public int getInstock() {
	return instock;
}
public void setInstock(int instock) {
	this.instock = instock;
}
public String getBrand() {
	return this.brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getProd_id() {
	return prod_id;
}
public void setProd_id(int prod_id) {
	this.prod_id = prod_id;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
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
public Product(String category, String name, String desc,
		String price,String brand, String filePath, int instock) {
	
	this.instock=instock;
	this.category = category;
	this.name = name;
	this.desc = desc;
	this.price = price;
	this.brand=brand;
	this.filePath=filePath;
}
public String getFilePath() {
	return filePath;
}
public void setFilePath(String filePath) {
	this.filePath = filePath;
}
public Product() {
	// TODO Auto-generated constructor stub
}



}
