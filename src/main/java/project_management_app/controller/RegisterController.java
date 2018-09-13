/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project_management_app.model.User;
import project_management_app.service.UserService;
/**
 *
 * @author tekane
 */
@Controller
public class RegisterController {
    
    @Autowired
    private UserService userService;
 
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        
        model.addAttribute("user", new User());
        return "views/registerForm";
    }
    
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUser(@Valid User user,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
       // boolean userExits =  userService.isUserPresent(user.getEmail());
       /* if (userService.isUserPresent(user.getEmail())){
             return "views/registerForm";
        }else{
            userService.CreateUser(user);
            return "views/success";
        }*/
            userService.CreateUser(user);
            return "views/success";
    }
}
