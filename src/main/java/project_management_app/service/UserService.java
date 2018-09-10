/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project_management_app.model.Role;
import project_management_app.model.User;
import project_management_app.repository.UserRepository;
/**
 *
 * @author tekane
 */
@Service
@Qualifier("userService")
public class UserService {
    
    @Autowired
    private UserRepository  userRepository;
     public void CreateUser(User user){
        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
         Role userRole  = new Role("USER");
        List<Role> roles =  new ArrayList<>();
        roles.add(userRole);
        userRepository.save(user);
    }
        
    public void CreateAdmin(User user){
        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole  = new Role("ADMIN");
        List<Role> roles =  new ArrayList<>();
        roles.add(userRole);
        userRepository.save(user);
    }
    public User findOne(String email){
        return userRepository.getOne(email);
    } 
    public boolean isUserPresent(String email) {
        User user =  userRepository.getOne(email);
        if(user != null) {
            return true;
        }else{
            return false;
        }
        
    }
}
