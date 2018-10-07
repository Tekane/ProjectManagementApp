package project_management_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project_management_app.model.User;
import org.springframework.context.annotation.ComponentScan;
import project_management_app.service.UserService;
@SpringBootApplication
@ComponentScan({"project_management_app.service","project_management_app.controller",
    "project_management_app.configuration"})
public class ProjectManagementApplication implements CommandLineRunner{
    @Autowired
    private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        User newAdmin = new User("phashaAdmin@gmail.com", "Admin", "19920602");
        userService.CreateAdmin(newAdmin);
        
    }
        
}
