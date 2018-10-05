/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
/**
 *
 * @author tekane
 */
@Entity
public class User implements Serializable {
    private String email;
    private String name;
    private String password;
    private List<Task> tasks;
    private List<Role> roles;

    public User() {
    
    }

    public User(String email) {
        this.email = email;
    }
    
    public User(List<Task> tasks, List<Role> roles) {
        this.tasks = tasks;
        this.roles = roles;
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
    @Id
    @Email
    @NotEmpty(message = "Please enter valid email address")
    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotEmpty(message = "Name should not be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Size(min = 4)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLES",joinColumns ={@JoinColumn(name = "USER_EMAIL",referencedColumnName = "email")}
    ,inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME",referencedColumnName = "name")}) 
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
