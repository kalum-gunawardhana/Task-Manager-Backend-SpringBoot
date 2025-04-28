package edu.task_management_backend.repository;

import edu.task_management_backend.entity.Task;
import edu.task_management_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
