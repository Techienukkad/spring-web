package com.techienuaakd.web.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.techienuaakd.web.validation.ValidEmail;

public class User {

	@NotNull(message="Username cannot be blank.")
	@Size(max=25,min=6,message="Username must be between 8 and 15 characters long.")
	@Pattern(regexp="^\\\\w{8,}$",message="Username can only consist of numbers, letters and the underscore character.")
	private String username;
	@Pattern(regexp="^\\\\w{8,}$",message="")
	@NotNull(message="Username cannot be blank.")
	@Pattern(regexp="^\\S+$", message="Password cannot contain spaces.")
	@Size(min=8, max=15, message="Password must be between 8 and 15 characters long.")
	private String password;
	private boolean enabled = false;
	@ValidEmail(message="Not a valid Email")
	private String email;
	private String authority;
	
	public User()
	{
		
	}

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param email
	 * @param authority
	 */
	public User(String username, String password, boolean enabled, String email, String authority) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.authority = authority;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
