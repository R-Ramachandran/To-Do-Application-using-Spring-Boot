package com.todo.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone_no")
	private String phoneNumber;
	
	@Column(name = "birth_date")
	private String birthDate;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Todo> todo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public List<Todo> getTodo() {
		return todo;
	}

	public void setTodo(List<Todo> todo) {
		this.todo = todo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	protected User() {
		
	}

	protected User(String name, String userId, String password, String emailId, String phoneNumber, String birthDate,
			List<Todo> todo) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.todo = todo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userId=" + userId + ", password=" + password + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", todo=" + todo + "]";
	}
	
	
	
}