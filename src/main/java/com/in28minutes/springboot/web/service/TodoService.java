package com.in28minutes.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.web.model.Todo;
import com.in28minutes.springboot.web.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository repository;
	
	// --> Initial Todo(s)
	private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;
    
    static {
    	todos.add(new Todo(1,"in28Minutes","Learn Spring MVC",new Date(),false));
    	todos.add(new Todo(2,"in28Minutes","Learn Struts",new Date(),false));
    	todos.add(new Todo(3,"in28Minutes","Learn Hibernate",new Date(),false));
    }
    
	// --> Retrieve Todos by username
    public List<Todo> retrieveTodos(String user){
    	
    	
		/*
		 * List<Todo> filteredTodos = new ArrayList<Todo>(); for(Todo todo : todos) {
		 * if(todo.getUser().equalsIgnoreCase(user)) filteredTodos.add(todo); }
		 * 
		 * return filteredTodos;
		 */
    	
    	return repository.findByUser(user);
    }
    
	// --> Add Todo ++curid
    public void addTodo(String name,String desc,Date targetDate,boolean isDone) {
		todos.add(new Todo(++todoCount,name,desc,targetDate,isDone));

	}
    
    public void saveTodo(Todo todo) {
    	repository.save(todo);
    }
    
	// --> Delete Todo by id
	public void deleteTodo(int id) {
		/*
		 * Iterator<Todo> iterator = todos.iterator(); while(iterator.hasNext()) { Todo
		 * todo = iterator.next(); if(todo.getId()==id) iterator.remove(); }
		 */
		repository.deleteById(id);
	}
	
	public Todo retrieveTodo(int id) {
		/*
		 * for(Todo todo : todos) { if(todo.getId()==id) { return todo; } } return null;
		 */
		return repository.getById(id);
	}
	
	public void updateTodo(Todo todo) {
		/*
		 * todos.remove(todo); todos.add(todo);
		 */
		repository.save(todo);
	}
	
}
