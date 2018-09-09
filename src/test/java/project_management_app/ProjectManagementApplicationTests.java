package project_management_app;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project_management_app.model.Task;
import project_management_app.model.User;
import project_management_app.service.TaskService;
import project_management_app.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagementApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    
        public  void intDB(){
        {
            User newUser = new User("phashaUser@gmail.com","testUser","123456");
            userService.CreateUser(newUser);
            
        }
        {
            User newUser = new User("phashaAdmin@gmail.com","testAdmin","123456");
            userService.CreateUser(newUser);
        }
            Task task = new Task("03/01/2018", "08:00", "11:00", "The work you need to complete today");
            User user =  userService.findOne("phashaUser@gmail.com");
            taskService.addTask(task, user);        
       }
    @Test
    public  void testUser(){
        User user =  userService.findOne("phashaUser@gmail.com");
        Assert.assertNotNull(user);
        User admin =  userService.findOne("phashaAdmin@gmail.com");
        Assert.assertEquals(admin.getEmail(),"phashaAdmin@gmail.com");
    }
   // @Test
    public void testTask(){
        User user = userService.findOne("phashaUser@gmail.com");
        List<Task> tasks =  taskService.findUserTask(user);
        Assert.assertNotNull(tasks);
    }
}
