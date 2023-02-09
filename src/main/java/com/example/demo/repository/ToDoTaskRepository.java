package com.example.demo.repository;
import java.util.Date;
import com.example.demo.entity.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Long> {
    ToDoTask findByDate (Date date);
    ToDoTask findByOwner (String owner);
    ToDoTask findByDescription (String description);
}
