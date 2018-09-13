/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author tekane
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/","index"},method = RequestMethod.GET)
    private ModelAndView getIndexPage(){
       ModelAndView model = new ModelAndView();
       model.setViewName("index");
       return  model;
    }
    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
    }
}
