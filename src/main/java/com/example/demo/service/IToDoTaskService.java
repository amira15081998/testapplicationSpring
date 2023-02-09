package com.example.demo.service;

import com.example.demo.entity.ToDoTask;
import java.util.*;
public interface IToDoTaskService {
    //CRUD SUR LES TAF
    public ToDoTask addToDoTask(ToDoTask toDoTask);
    public  void deleteToDoTask (Long id);
    public Object updateToDoTask(ToDoTask toDoTask);

    public ToDoTask findToDoTask(Long id);

    public List<ToDoTask> findAll();

    ToDoTask findByDescription(String description);

    ToDoTask findByDate(Date date);

    ToDoTask findByOwner(String owner);
}
