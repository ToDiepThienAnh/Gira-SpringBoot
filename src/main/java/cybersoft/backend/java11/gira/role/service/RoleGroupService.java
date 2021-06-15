package cybersoft.backend.java11.gira.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.model.RoleGroup;
import cybersoft.backend.java11.gira.role.repository.RoleGroupRepositoryInf;

@Service
public class RoleGroupService implements RoleGroupServiceInf {
	@Autowired
	private RoleGroupRepositoryInf _repository;
	
	
	@Override
	public List<RoleGroup> findAll() {
		// TODO Auto-generated method stub
		return _repository.findAll();
	}

	@Override
	public void save(RoleGroup entity) {
		// TODO Auto-generated method stub
		_repository.save(entity);
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<RoleGroup> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleGroup addRole(Role role, long id) {
		// TODO Auto-generated method stub
		RoleGroup group = _repository.getOne(id);
		group.addRole(role);
		
		return _repository.save(group);
	}

	@Override
	public RoleGroup update(RoleGroup entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleGroup removeRole(Role role, long id) {
		RoleGroup group = _repository.getOne(id);
		group.removeRole(role);
		
		
		return _repository.save(group);
	}

}
