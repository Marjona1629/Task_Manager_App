package org.example.taskmanager.controller;

import org.example.taskmanager.dto.TaskDto;
import org.example.taskmanager.model.Task;
import org.example.taskmanager.model.User;
import org.example.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // Assume user is already authenticated; for demo we pass a mock user
    private User getMockUser() {
        return User.builder().id(1L).username("demo").role("USER").build();
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasksByUser(getMockUser());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task, getMockUser());
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        Task task = Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .build();
        Task savedTask = taskService.createTask(task, getMockUser());
        return TaskDto.builder()
                .id(savedTask.getId())
                .title(savedTask.getTitle())
                .description(savedTask.getDescription())
                .completed(savedTask.isCompleted())
                .build();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}