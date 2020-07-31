package com.todo.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo.project.entity.User;

@Repository
@Transactional
public class UserRepository {
	
	@PersistenceContext
	@Autowired
	EntityManager em;
	
	public User findUserByUserIdAndPasswordId(String userId, String password) {
		Query query = em.createNativeQuery("select * from person where user_id = :userId and password = :password", User.class);
		query.setParameter("userId", userId);
		query.setParameter("password", password);
		try {
			return (User) query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public User findUserByUserId(String userId) {
		Query query = em.createNativeQuery("select * from person where user_id = :userId", User.class);
		query.setParameter("userId", userId);
		try {
			return (User) query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public void insert(User user) {
		em.persist(user);
	}
	
	public void delete(User user) {
		em.remove(user);
	}
	
	public User update(User user) {
		return em.merge(user);
	}
}