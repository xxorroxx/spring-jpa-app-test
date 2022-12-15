package com.develop.springapi.service;

import com.develop.springapi.mapper.TaskDtoToTask;
import com.develop.springapi.persistence.entity.Task;
import com.develop.springapi.persistence.entity.TaskStatus;
import com.develop.springapi.persistence.repository.TaskRepository;
import com.develop.springapi.service.dto.TaskDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskDtoToTask adapter;

    public TaskService(TaskRepository repository, TaskDtoToTask adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    public Task createTask(TaskDto taskDto) {

        Task task = adapter.map(taskDto);
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskFinished(Long id) {
        repository.markTaskAsFinished(id);
    }
}
