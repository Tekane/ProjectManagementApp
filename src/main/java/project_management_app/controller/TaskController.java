/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project_management_app.model.Task;
import project_management_app.model.User;
import project_management_app.service.TaskService;
import project_management_app.service.UserService;
/**
 *
 * @author tphasha
 */
@Controller
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/addTask")
    public  String taskForm(String email,Model model,HttpSession httpSession){
        httpSession.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "views/taskForm";
    }
     @PostMapping("/addTask")
     public String addTask(@Valid Task task,BindingResult bindingResult,HttpSession httpSession){
         if(bindingResult.hasErrors()){
              return "views/taskForm";
         }
         String email = (String) httpSession.getAttribute("email");
         User  user =  userService.findOne(email);
         taskService.addTask(task, user);
         return "redirect:/users" ;
     }
}
