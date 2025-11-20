package com.javaguy.asm.service;

import com.javaguy.asm.model.Task;
import com.javaguy.asm.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService{

    private final TaskRepository taskRepository;

    public Task createTask(Task task){
        log.info("Creating task {}", task);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        log.info("Getting all tasks");
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        log.info("Getting task with id {}", id);
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTaskById(Long id){
        log.info("Deleting task with id {}", id);
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
