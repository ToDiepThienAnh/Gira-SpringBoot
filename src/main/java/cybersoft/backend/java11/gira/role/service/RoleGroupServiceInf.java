package cybersoft.backend.java11.gira.role.service;

import cybersoft.backend.java11.gira.commondata.GenericService;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.model.RoleGroup;

public interface RoleGroupServiceInf extends GenericService<RoleGroup, Long>{
	public RoleGroup addRole(Role role, long id);
	public RoleGroup removeRole(Role role, long id);
}
