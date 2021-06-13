package cybersoft.backend.java11.gira.role.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.repository.RoleRepositoryInf;

@Service
public class RoleService implements RoleServiceInf {
	@Autowired
	private RoleRepositoryInf _repository;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return _repository.findAll();
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		_repository.save(role);
		System.out.println("Role added" + role);
	}

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
	public Role updateRoleInfo(CreateRoleDTO dto, Long roleId) {
		// TODO Auto-generated method stub
		Role role = _repository.getOne(roleId);
		role.roleName(dto.roleName)
			.description(dto.description);
		
		return _repository.save(role);
	}

	@Override
	public void deleteById(Long roleId) {
		// TODO Auto-generated method stub
		_repository.deleteById(roleId);
	}
	
//	@Override
//	public void save(Role role) {
//		// TODO Auto-generated method stub
//		_repository.save(role);
//	}
//
//	@Override
//	public List<Role> findAll() {
//		// TODO Auto-generated method stub
//		
//		return _repository.findAll();
//	}
//
//	@Override
//	public List<Role> findByRoleName(String roleName) {
//		// TODO Auto-generated method stub
//		return _repository.findByRoleName(roleName);
//	}
//
//	@Override
//	public List<Role> findByDescription(String description) {
//		// TODO Auto-generated method stub
//		return _repository.findByDescriptionContainingOrderByIdAsc(description);
//	}
//
//	@Override
//	public List<Role> findRoleWithoutBlankDescription(String roleName) {
//		// TODO Auto-generated method stub
//		return _repository.findRoleWithNotNullDescription(roleName);
//	}
//
//	@Override
//	public List<RoleWithAccountsDTO> findRoleWithAccountInfo() {
//		List<Role> roles = _repository.findAll();
//		List<RoleWithAccountsDTO> results = mapRoleToRoleWithAccountsDTO(roles);
//		return results;
//	}
//	
//	private List<RoleWithAccountsDTO> mapRoleToRoleWithAccountsDTO(List<Role> roles){
//		List<RoleWithAccountsDTO> results = new LinkedList<RoleWithAccountsDTO>();
//		
//		for (Role role : roles) {
//			RoleWithAccountsDTO dto = new RoleWithAccountsDTO();
//			mapRoleToDto(dto, role);
//			results.add(dto);
//		}
//		
//		return results;
//	}
//	
//	private void mapRoleToDto(RoleWithAccountsDTO dto, Role role) {
//		dto.setId(role.getId());
//		dto.setRoleName(role.getRoleName());
//		dto.setDescription(role.getDescription());
//		dto.setAccounts(role.getAccounts());
//	}

}
