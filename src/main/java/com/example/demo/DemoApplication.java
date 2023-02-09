package com.example.demo;
import com.example.demo.entity.ToDoTask;
import com.example.demo.repository.ToDoTaskRepository;
import com.example.demo.service.IToDoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


	@Autowired
	ToDoTaskRepository toDoTaskRepository;
@Autowired
IToDoTaskService toDoTaskService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//add TAF
		ToDoTask toDoTask = new ToDoTask("tache a faire 1", new Date(), "amira");
		ToDoTask toDoTask2 = new ToDoTask("tache a faire 2", new Date(), "ahmed");
		toDoTaskRepository.save(toDoTask);
		toDoTaskRepository.save(toDoTask2);
		//delete TAF
		//tafrep.deleteById(1L);
		//update TAF
		ToDoTask t = toDoTaskService.findToDoTask(2L);
		t.setOwner("mahdi");
		toDoTaskService.updateToDoTask(t);
		//Liste TAF
		List<ToDoTask> tafliste= toDoTaskRepository.findAll();
		for (ToDoTask tache:tafliste){
			System.out.println(tache.getDescription()+" "+tache.getDate()+" "+tache.getOwner());
		}

	}
}
