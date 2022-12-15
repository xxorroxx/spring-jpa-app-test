package com.develop.springapi.mapper;

import com.develop.springapi.persistence.entity.Task;
import com.develop.springapi.persistence.entity.TaskStatus;
import com.develop.springapi.service.dto.TaskDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskDtoToTask implements IMapper<TaskDto, Task>{

    @Override
    public Task map(TaskDto in) {

        //Se crea Task que se va a devolver
        Task task =  new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
