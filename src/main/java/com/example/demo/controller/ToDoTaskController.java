package com.example.demo.controller;

import com.example.demo.entity.ToDoTask;
import com.example.demo.service.IToDoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/task")
public class ToDoTaskController {
    @Autowired
    IToDoTaskService IToDoTaskService;
    @GetMapping(value = "")
    public List<ToDoTask> findTasks() {
        return IToDoTaskService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ToDoTask findTaskById(@PathVariable Long id) {
        return IToDoTaskService.findToDoTask(id);
    }

    @GetMapping(value = "/search/description")
    public ToDoTask findTaskByDescription(@RequestParam String description) {
        return IToDoTaskService.findByDescription(description);
    }

    @GetMapping(value = "/search/date")
    public ToDoTask findTaskByDate(@RequestParam Date date) {
        return IToDoTaskService.findByDate(date);
    }

    @GetMapping(value = "/search/owner")
    public ToDoTask findTaskByOwner(@RequestParam String owner) {
        return IToDoTaskService.findByOwner(owner);
    }

    @PostMapping(value = "")
    public ToDoTask addTask(@RequestBody ToDoTask toDoTask) {
        return IToDoTaskService.addToDoTask(toDoTask);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable Long id) {
        IToDoTaskService.deleteToDoTask(id);

    }

    @PutMapping(value = "/{id}")
    public ToDoTask updateTask(@PathVariable Long id, @RequestBody ToDoTask toDoTask) {

        toDoTask.setId(id);
        return (ToDoTask) IToDoTaskService.updateToDoTask(toDoTask);

    }

}
