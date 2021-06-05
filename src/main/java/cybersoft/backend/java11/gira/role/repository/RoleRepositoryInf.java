package cybersoft.backend.java11.gira.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cybersoft.backend.java11.gira.role.model.Role;

@Repository
public interface RoleRepositoryInf extends JpaRepository<Role, Long>{
	List<Role> findByRoleName(String roleName);
	List<Role> findByDescriptionContainingOrderByIdAsc(String description);
	
	@Query("SELECT r FROM Role r WHERE r.roleName=:roleName AND r.description IS NOT NULL")
	List<Role> findRoleWithNotNullDescription(@Param("roleName")String roleName);
}
