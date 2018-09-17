/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project_management_app.service.UserService;
/**
 *
 * @author tphasha
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public  String listUser(Model model ,@RequestParam(defaultValue="") String name){
        model.addAttribute("users", userService.findByName(name));
        return "views/list";
    }
}
