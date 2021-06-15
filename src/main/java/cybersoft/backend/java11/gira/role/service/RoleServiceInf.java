package cybersoft.backend.java11.gira.role.service;

import java.util.List;

import cybersoft.backend.java11.gira.commondata.GenericService;
import cybersoft.backend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;

public interface RoleServiceInf extends GenericService<Role, Long> {
	Role update(CreateRoleDTO dto);
	List<RoleWithAccountsDTO> findAllWithAccount();
	List<Role> findByRoleName(String roleName);
	List<Role> findByDescriptionContainingOrderByIdAsc(String description);
	List<Role> findRoleNameWidthDescriptionNotBlank(String roleName);
}
