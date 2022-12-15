package com.develop.springapi.controller;

import com.develop.springapi.persistence.entity.Task;
import com.develop.springapi.persistence.entity.TaskStatus;
import com.develop.springapi.service.TaskService;
import com.develop.springapi.service.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDto taskDto){
        return taskService.createTask(taskDto);
    }

    @GetMapping()
    public List<Task> findAll() {
        return taskService.findAll();
    }

    // El @PathVariable lo que hace es leer el parametros que pasamos en el path: /status/{status}"
    @GetMapping("/status/{status}")
    public  List<Task> getAllTaskStatus(@PathVariable("status")TaskStatus status) {
        return taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        taskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

}
