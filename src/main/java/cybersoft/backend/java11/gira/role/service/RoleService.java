package cybersoft.backend.java11.gira.role.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.repository.RoleRepositoryInf;

@Service
public class RoleService implements RoleServiceInf {
	@Autowired
	private RoleRepositoryInf _repository;
	
	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		_repository.save(role);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		
		return _repository.findAll();
	}

	@Override
	public List<Role> findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return _repository.findByRoleName(roleName);
	}

	@Override
	public List<Role> findByDescriptionContainingAndOrderByIdAsc(String description) {
		// TODO Auto-generated method stub
		return _repository.findByDescriptionContainingOrderByIdAsc(description);
	}

	@Override
	public List<RoleWithAccountsDTO> findRoleWithAccountsInfo() {
		// TODO Auto-generated method stub
		List<Role> roles = _repository.findAll();
		
		System.out.println("Holding to debug");
		return null;
	}

}
