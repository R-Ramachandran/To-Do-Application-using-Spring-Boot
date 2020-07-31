package com.todo.project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.project.entity.Todo;
import com.todo.project.entity.User;
import com.todo.project.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public void addTodo(User user, Date startDate, Date endDate, String title, String description, String estTime, String priority, String place) {
		Todo todo = new Todo(user, title,  startDate, endDate, priority, description, place, estTime);
		todoRepository.insert(todo); 
	}

	public void deleteTodo(long id) {
		todoRepository.delete(id);
	}

	public void updateTodo(Todo todo) {
		todoRepository.update(todo);
	}

}
