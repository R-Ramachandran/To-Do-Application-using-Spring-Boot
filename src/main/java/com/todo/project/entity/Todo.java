package com.todo.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "todo_list")
public class Todo {

	@Id
	@GeneratedValue
	@Column(name = "todo_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Column(name = "todo_title")
	@Size(min = 5, message = "* Enter atleast 5 characters")
	private String todoTitle;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	
	@Column(name = "due_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "detail")
	@Size(min = 10, message = "* Enter atleast 10 characters")
	private String detail;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "est_time")
	private String estTime;

	public User getUser() {
		return user;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTodoTitle() {
		return todoTitle;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getEstTime() {
		return estTime;
	}

	public void setEstTime(String estTime) {
		this.estTime = estTime;
	}

	public long getId() {
		return id;
	}

	protected Todo() {
		
	}
	
	public Todo(User user, String todoTitle, Date startDate, Date dueDate, String priority,
			String detail, String place, String estTime) {
		super();
		this.user = user;
		this.todoTitle = todoTitle;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.priority = priority;
		this.detail = detail;
		this.place = place;
		this.estTime = estTime;
	}
	
}
