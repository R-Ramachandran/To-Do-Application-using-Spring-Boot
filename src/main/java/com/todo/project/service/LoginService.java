package com.todo.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.project.entity.User;
import com.todo.project.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;
	
	public boolean checkUser(String userId, String password) {
		boolean isPresent=false;
		User user = userRepository.findUserByUserIdAndPasswordId(userId, password);
		if(user != null)
			isPresent = true;
		return isPresent;
	}

}

