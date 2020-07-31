package com.todo.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo.project.repository.TodoRepository;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	@Autowired
	TodoRepository todoRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//logger.info("Todos[10001] ====>> {}", todoRepository.findByUserId(10001L));
	}

}
