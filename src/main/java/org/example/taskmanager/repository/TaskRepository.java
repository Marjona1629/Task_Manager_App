package org.example.taskmanager.repository;

import org.example.taskmanager.model.Task;
import org.example.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}