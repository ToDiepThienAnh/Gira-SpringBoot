package cybersoft.backend.java11.gira.role.service;

import java.util.List;

import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;

public interface RoleServiceInf {
//	void save(Role role);
//	List<Role> findAll();
//	List<Role> findByRoleName(String roleName);
//	List<Role> findByDescription(String description);
//	List<Role> findRoleWithoutBlankDescription(String roleName);
//	List<RoleWithAccountsDTO> findRoleWithAccountInfo();
	
	List<Role> findAll();
	List<RoleWithAccountsDTO> findAllWithAccount();
	void save(Role role);
	List<Role> findByRoleName(String roleName);
	List<Role> findByDescriptionContainingOrderByIdAsc(String description);
	List<Role> findRoleNameWidthDescriptionNotBlank(String roleName);
}
