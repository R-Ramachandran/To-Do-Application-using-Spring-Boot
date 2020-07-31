package com.todo.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo.project.entity.Todo;

@Repository
@Transactional
public class TodoRepository {

	@PersistenceContext
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Todo> findByUserId(long userId) {
		Query query = em.createNativeQuery("select * from todo_list where user_id = :userId", Todo.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	
	public void insert(Todo todo) {
		em.persist(todo);
	}
	
	public void delete(long id) {
		em.remove(em.find(Todo.class, id));
	}
	
	public Todo update(Todo todo) {
		return em.merge(todo);
	}

	public Todo findByTodoId(long id) {
		return em.find(Todo.class, id);
	}
}