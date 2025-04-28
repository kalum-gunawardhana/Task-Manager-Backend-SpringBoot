package edu.task_management_backend.service;

import edu.task_management_backend.entity.Task;
import edu.task_management_backend.entity.User;
import java.util.List;

public interface TaskService {
    List<Task> getTasksByUser(User user);
    Task createTask(Task task, User user);
    Task updateTask(Long taskId, Task updatedTask);
    void deleteTask(Long taskId);
}