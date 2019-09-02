package com.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Privilege implements Serializable{

	private int id;
	private String module;
	private String superior_module;
	private String url;
	private int grade;
	
	private List<Privilege> listtwo;
	
	public List<Privilege> getListtwo() {
		return listtwo;
	}
	public void setListtwo(List<Privilege> listtwo) {
		this.listtwo = listtwo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getSuperior_module() {
		return superior_module;
	}
	public void setSuperior_module(String superior_module) {
		this.superior_module = superior_module;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
 
	
	
}
