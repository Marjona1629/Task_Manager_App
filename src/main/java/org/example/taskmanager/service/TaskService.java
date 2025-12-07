package org.example.taskmanager.service;

import org.example.taskmanager.model.Task;
import org.example.taskmanager.model.User;
import org.example.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task, User user) {
        task.setUser(user);
        task.setCreatedAt(LocalDateTime.now());
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}