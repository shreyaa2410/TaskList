package com.example.TaskList.controller;
import com.example.TaskList.modal.Task;
import com.example.TaskList.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasklist/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        List<Task> tasks= taskService.getTask();
         return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createTask(@Valid @RequestBody Task task){
       String message= taskService.createTaskService(task);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getAllTask(@PathVariable(value = "id") Long id){
        Task taskById= taskService.getTaskById(id);
        return new ResponseEntity<>(taskById, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String>  updateTask(@PathVariable(value="id") Long id,@Valid @RequestBody Task task){
        String mesage=taskService.updateTask(id,task);
        return new ResponseEntity<>(mesage,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteById(@PathVariable Long id){
        String message= taskService.deleteTask(id);
        return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Long id){
        String message=taskService.updateStatus(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
