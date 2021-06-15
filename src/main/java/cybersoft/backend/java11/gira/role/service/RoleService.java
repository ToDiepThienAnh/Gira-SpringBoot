package cybersoft.backend.java11.gira.role.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.backend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.repository.RoleRepositoryInf;

@Service
public class RoleService extends GenericServiceImpl<Role, Long> implements RoleServiceInf {
	@Autowired
	private RoleRepositoryInf _repository;

	@Override
	public List<Role> findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return _repository.findByRoleName(roleName);
	}

	@Override
	public List<Role> findByDescriptionContainingOrderByIdAsc(String description) {
		// TODO Auto-generated method stub
		return _repository.findByDescriptionContainingOrderByIdAsc(description);
	}

	@Override
	public List<Role> findRoleNameWidthDescriptionNotBlank(String roleName) {
		// TODO Auto-generated method stub
		return _repository.findRoleNameWidthDescriptionNotBlank(roleName);
	}

	@Override
	public List<RoleWithAccountsDTO> findAllWithAccount() {
		// TODO Auto-generated method stub
		List<Role> listRole = _repository.findAll();
		List<RoleWithAccountsDTO> listRoleWithAccount = new LinkedList<RoleWithAccountsDTO>();
		for (Iterator iterator = listRole.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			RoleWithAccountsDTO dto = new RoleWithAccountsDTO();
			mapRoleToRoleWithAccountDTO(dto, role);
			listRoleWithAccount.add(dto);
		}
		return listRoleWithAccount;
	}
	
	
	
	private void mapRoleToRoleWithAccountDTO(RoleWithAccountsDTO dto, Role role) {
		dto.setId(role.getId());
		dto.setRoleName(role.getRoleName());
		dto.setDescription(role.getDescription());
		dto.setAccounts(role.getAccounts());
	}

	@Override
	public Role update(CreateRoleDTO dto) {
		// TODO Auto-generated method stub
		Role role = new Role().roleName(dto.roleName)
					.description(dto.description);
		return _repository.save(role);
	}
	
}
