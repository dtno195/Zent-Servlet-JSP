package com.zent.entity;

public class User {
	private Long userId;
	private String username;
	private String password;
	private String fullName;
	private Long roleId;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String fullName, Long roleId) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.roleId = roleId;
	}

	public User(Long userId, String username, String password, String fullName, Long roleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.roleId = roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
	
}
