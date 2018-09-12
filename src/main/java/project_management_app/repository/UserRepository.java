/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import project_management_app.model.User;
/**
 *
 * @author tekane
 */
public interface UserRepository  extends JpaRepository<User, String>{
    public List<User> findByNameLike(String name);

    public User findOne(String email);
    
}
