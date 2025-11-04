package com.example.TaskList.service;

import com.example.TaskList.exception.TaskNotFoundException;
import com.example.TaskList.modal.Task;
import com.example.TaskList.modal.TaskStatus;
import com.example.TaskList.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static com.example.TaskList.modal.TaskStatus.COMPLETED;

@Service
public class TaskService {
    private TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
    public List<Task> getTask(){
        return taskRepo.findAll();
    }
    public String createTaskService(Task task){
        taskRepo.save(task);
        return "Task created for: "+task.getTitle();
    }

    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found with id: "+id));
    }

    public String updateTask(Long id,Task task) {
        Task existingTask = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task does not exist with id: " + id));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setStatus(task.getStatus());
        taskRepo.save(existingTask);
        return "Saved Task"+existingTask.getTitle();
    }

    public String deleteTask(Long id) {
        taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task does not exist with id: " + id));
        taskRepo.deleteById(id);
        return "Task Deleted for this id: "+id;
    }

    public String updateStatus(Long id) {
        Task existingTask = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task does not exist with id: " + id));
        existingTask.setStatus(COMPLETED);
        taskRepo.save(existingTask);
        return "Updated Status for this id: "+id;
    }
}
