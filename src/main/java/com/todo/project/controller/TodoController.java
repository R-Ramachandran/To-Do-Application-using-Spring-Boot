package com.todo.project.controller;

import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todo.project.entity.Todo;
import com.todo.project.entity.User;
import com.todo.project.repository.TodoRepository;
import com.todo.project.repository.UserRepository;
import com.todo.project.service.TodoService;

@Controller
@SessionAttributes("username")
public class TodoController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	TodoService todoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Todo.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getWelcomePage(ModelMap model) {
		User user = userRepository.findUserByUserId(getLoggedInUsername());
		model.put("name", user.getName());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principle instanceof UserDetails)
			return ((UserDetails) principle).getUsername();
		return principle.toString();
	}

	@RequestMapping(value = "/todo-list", method = RequestMethod.GET)
	public String getTodoPage(ModelMap model) {
		String username = getLoggedInUsername(); 
		User user = userRepository.findUserByUserId(username);
		long userId = user.getId();
		model.put("name", user.getName());
		model.put("todos", todoRepository.findByUserId(userId));
		return "todo-list";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String getAddTodoPage(ModelMap model) {
		String username = getLoggedInUsername(); 
		User user = userRepository.findUserByUserId(username);
		model.put("name", user.getName());
		model.put("newOrUpdate", "Add");
		model.put("newOrUpdateDescription", "add your new");
		model.addAttribute("todo", new Todo(user, null, null, null, null, null, null, null));
		return "todo";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoFromList(ModelMap model, @RequestParam long id) {
		todoService.deleteTodo(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodoFromList(ModelMap model, @RequestParam long id) {
		String username = getLoggedInUsername(); 
		User user = userRepository.findUserByUserId(username);
		model.put("name", user.getName());
		model.put("newOrUpdate", "Update");
		model.put("newOrUpdateDescription", "update your");
		model.addAttribute("todo", todoRepository.findByTodoId(id));
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String postUpdatedTodoByUser(@Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult, ModelMap model) {
		String username = getLoggedInUsername(); 
		User user = userRepository.findUserByUserId(username);
		if(bindingResult.hasErrors()) {
			model.put("name", user.getName());
			model.put("newOrUpdate", "Update");
			model.put("newOrUpdateDescription", "update your");
			return "todo";
		}
		todo.setId(todo.getId());
		todo.setUser(user);
		todoService.updateTodo(todo);
		model.put("name", user.getName());
		model.put("todos", todoRepository.findByUserId(user.getId()));
		return "redirect:todo-list";
	}
/*
	public String getLoggedInUsername(ModelMap model) {
		String username = (String) model.get("username");
		return username;
	}
*/
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancelToRedirect() {
		return "redirect:todo-list";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String postAddTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult, ModelMap model) {
		String username = getLoggedInUsername(); 
		User user = userRepository.findUserByUserId(username);
		if(bindingResult.hasErrors()) {
			model.put("name", user.getName());
			model.put("newOrUpdate", "Add");
			model.put("newOrUpdateDescription", "add your new");
			return "todo";
		}
		else {
			model.put("name", user.getName());
			todoService.addTodo(user, todo.getStartDate(), todo.getDueDate(), todo.getTodoTitle(), 
					todo.getDetail(), todo.getEstTime(), todo.getPriority(), todo.getPlace());
			long userId = user.getId();
			model.put("todos", todoRepository.findByUserId(userId));
			return "todo-list";
		}
	}
}
