package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {

	
	@Id
	private int slno;
	private String username;
	private String password;
	private String roles;
	
	
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
    
	
  
}
