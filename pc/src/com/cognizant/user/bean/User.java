package com.cognizant.user.bean;
import java.util.*;
public class User{
	String name;
	String username;
	int id;
	String mail;
	long mobile;
	String password;
	String desig;
	String address;
	List<Integer> pid;
	List<Integer> required;
	public List<Integer> getPid() {
		return pid;
	}
	public void setPid(List<Integer> pid) {
		this.pid = pid;
	}
	public List<Integer> getRequired() {
		return required;
	}
	public void setRequired(List<Integer> required) {
		this.required = required;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String designation;
	public User(String name,String username,String mail,long mobile,String password, String desig)
	{
	this.name=name;
    this.username=username;
	this.mail=mail;
	this.mobile=mobile;
	this.password=password;
	this.desig=desig;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long l) {
		this.mobile = l;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}


}
