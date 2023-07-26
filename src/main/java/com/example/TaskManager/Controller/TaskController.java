package com.example.TaskManager.Controller;

import com.example.TaskManager.Exceptions.ResourceNotFoundException;
import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	
	@Autowired
	TaskRepository taskrepository;
	
	// Get All Tasks
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
	    return taskrepository.findAll();
	}
	
	// Create a new task
	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
	    return taskrepository.save(task);
	}
	
	// Get a Single Task
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable(value = "id") Long taskId) {
	    return taskrepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));
	}
	
	// Update a Task
	@PutMapping("/task/{id}")
	public Task updateTask(@PathVariable(value = "id") Long taskId,
	                                        @Valid @RequestBody Task taskDetails) {

	    Task task = taskrepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

	    task.setTitle(taskDetails.getTitle());
	    task.setDescription(taskDetails.getDescription());

	    Task updatedTask = taskrepository.save(task);
	    return updatedTask;
	}
	
	// Delete a Task
	@DeleteMapping("/task/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long taskId) {
		Task task = taskrepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

	    taskrepository.delete(task);

	    return ResponseEntity.ok().build();
	}
}
