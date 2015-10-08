package com.vfcons.vferp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -4478317752112843924L;

	private Integer id;
	private String name;
	private String pw;
	private String email;
	private String state;
	private List<String> roles;

	public User() {

	}

	public User(String name, String pw, String email, List<String> roles) {
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
