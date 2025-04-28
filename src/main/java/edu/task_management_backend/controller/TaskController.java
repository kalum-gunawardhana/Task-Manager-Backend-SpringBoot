package edu.task_management_backend.controller;

import edu.task_management_backend.entity.Task;
import edu.task_management_backend.entity.User;
import edu.task_management_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Task>> getTasks(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(taskService.getTasksByUser(user));
    }

    @PostMapping("/add")
    public ResponseEntity<Task> createTask(@RequestBody Task task, @AuthenticationPrincipal User user){
       return ResponseEntity.ok(taskService.createTask(task, user));
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(taskId, task));
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
