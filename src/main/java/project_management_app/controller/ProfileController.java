/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project_management_app.model.User;
import project_management_app.service.TaskService;
import project_management_app.service.UserService;

/**
 *
 * @author tphasha
 */
@Controller
public class ProfileController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/profile")
    public String showProfilePage(Model model,Principal principal){
        String email =  principal.getName();
        User user =  userService.findOne(email);
        model.addAttribute("tasks", taskService.findUserTask(user));
        return "views/profile";
    }
}
