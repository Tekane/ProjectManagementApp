package project_management_app.model;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
/**
 *
 * @author tekane
 */
@Entity
public class Role {
    private String name;
    private List<User>  users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
    
    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }
 
    @Id
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "roles")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
