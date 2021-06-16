package cybersoft.backend.java11.gira.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.backend.java11.gira.role.model.RoleGroup;

@Repository
public interface RoleGroupRepositoryInf extends JpaRepository<RoleGroup, Long> {
//	@Query("SELECT r FROM Role r WHERE r.roleName =:roleName AND r.description IS NOT NULL ORDER BY r.id ASC")
//	public RoleGroup removeRole(Long groupId, Long roleId);
}
