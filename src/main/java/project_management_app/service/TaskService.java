/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import project_management_app.model.Task;
import project_management_app.model.User;
import project_management_app.repository.TaskRepository;
/**
 *
 * @author tekane
 */
@Service
@Qualifier("taskService")
public class TaskService {
    
     @Autowired
     private TaskRepository taskRepository;
    
      public void addTask(Task task,User user){
        task.setUser(user);
        taskRepository.save(task);
    }
    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }
}
