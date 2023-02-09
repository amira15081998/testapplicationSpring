package com.example.demo.service;

import com.example.demo.entity.ToDoTask;
import com.example.demo.repository.ToDoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ToDoTaskImpl implements IToDoTaskService {
@Autowired
ToDoTaskRepository toDoTaskRepository;
    @Override
    public ToDoTask addToDoTask(ToDoTask toDoTask) {
        toDoTaskRepository.save(toDoTask);
        return toDoTask;
    }

    @Override
    public void deleteToDoTask(Long id) {
        toDoTaskRepository.deleteById(id);

    }

    @Override
    public ToDoTask updateToDoTask(ToDoTask toDoTask) {

        return toDoTaskRepository.saveAndFlush(toDoTask);
    }

    @Override
    public ToDoTask findToDoTask(Long id) {
        ToDoTask toDoTask = (ToDoTask) toDoTaskRepository.findById(id).get();
        return toDoTask;
    }

    @Override
    public List<ToDoTask> findAll() {
        return toDoTaskRepository.findAll();
    }

    @Override
    public ToDoTask findByDescription(String description) {
        return toDoTaskRepository.findByDescription(description);
    }

    @Override
    public ToDoTask findByDate(Date date) {
        return toDoTaskRepository.findByDate(date);
    }

    @Override
    public ToDoTask findByOwner(String owner) {
        return toDoTaskRepository.findByOwner(owner);
    }
}
