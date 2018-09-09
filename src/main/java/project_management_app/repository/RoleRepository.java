
package project_management_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_management_app.model.Role;
/**
 *
 * @author tekane
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
    
}
