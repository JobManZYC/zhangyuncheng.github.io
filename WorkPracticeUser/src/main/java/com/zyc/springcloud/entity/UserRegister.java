package com.zyc.springcloud.entity;

public class UserRegister{
	private String username;
	private String password;
	private String role;
	private String permission;
	private String ban;
	private float money;
	
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegister(String username, String password, String role, String permission, String ban, float money) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.permission = permission;
		this.ban = ban;
		this.money = money;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * @return the ban
	 */
	public String getBan() {
		return ban;
	}

	/**
	 * @param ban the ban to set
	 */
	public void setBan(String ban) {
		this.ban = ban;
	}

	/**
	 * @return the money
	 */
	public float getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(float money) {
		this.money = money;
	}
	

}
