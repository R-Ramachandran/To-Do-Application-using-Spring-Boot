package com.todo.project.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
		auth.jdbcAuthentication().passwordEncoder(passwordEncoder)
			.dataSource(dataSource)
			.usersByUsernameQuery("select user_id, password, enabled from person where user_id=?")
			.authoritiesByUsernameQuery("select user_id, role from person where user_id=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.authorizeRequests()
			.antMatchers("/", "/login").permitAll()*/
		//	.antMatchers("/*todo*/**").access("hasRole('USER')").and()
		/*	.formLogin()
				.loginPage("/login").defaultSuccessUrl("/welcome").and().logout().clearAuthentication(true);
		*/
		http.authorizeRequests()
			.antMatchers("/","/login").permitAll().and()
			.authorizeRequests()
			.antMatchers("/","/login","/todo-list","/add-todo","/update-todo","/delete-todo","/welcome","/cancel").authenticated().and()
			.formLogin()
				.loginPage("/login").defaultSuccessUrl("/welcome").and().logout().logoutSuccessUrl("/login").permitAll();
		
		http.csrf().disable();
	}
	
}
