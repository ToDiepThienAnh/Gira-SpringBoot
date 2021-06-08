package cybersoft.backend.java11.gira.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.role.model.RoleGroup;
import cybersoft.backend.java11.gira.role.repository.RoleGroupInf;

@Service
public class RoleGroupService implements RoleGroupServiceInf {
	@Autowired
	private RoleGroupInf _repository;
	
	@Override
	public List<RoleGroup> findAll() {
		// TODO Auto-generated method stub
		return _repository.findAll();
	}

	@Override
	public Optional<RoleGroup> findById(Long id) {
		// TODO Auto-generated method stub
		return _repository.findById(id);
	}

	@Override
	public RoleGroup save(RoleGroup entity) {
		// TODO Auto-generated method stub
		return _repository.save(entity);
	}

	@Override
	public RoleGroup update(RoleGroup entity) {
		// TODO Auto-generated method stub
		return _repository.save(entity);
	}

	@Override
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		_repository.deleteById(id);
	}

}
