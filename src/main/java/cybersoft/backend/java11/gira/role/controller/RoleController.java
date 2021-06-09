package cybersoft.backend.java11.gira.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.backend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.service.RoleServiceInf;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private RoleServiceInf _service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAll(){
		List<Role> listRole = _service.findAll();
		
		if(listRole.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<>(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/{role-name}")
	public ResponseEntity<Object> findByRoleName(@PathVariable("role-name") String roleName){
		List<Role> listRole = _service.findByRoleName(roleName);
		
		if(listRole.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<>(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/description")
	public ResponseEntity<Object> findByDescriptionContainingOrderByIdAsc(@RequestParam("description")
					String description
			){
		List<Role> listRole = _service.findByDescriptionContainingOrderByIdAsc(description);
		
		if(listRole.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/description/{role-name}")
	public ResponseEntity<Object> findRoleNameWidthDescriptionNotBlank(@PathVariable("role-name") String roleName){
		List<Role> listRole = _service.findRoleNameWidthDescriptionNotBlank(roleName);
		
		if(listRole.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/with-account")
	public ResponseEntity<Object> findAllWithAccount(){
		List<RoleWithAccountsDTO> list = _service.findAllWithAccount();
		
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> save(@RequestBody CreateRoleDTO dto){
		Role roleAdd = new Role();
		roleAdd.roleName(dto.roleName).description(dto.description);
		_service.save(roleAdd);
		return new ResponseEntity<>(roleAdd, HttpStatus.CREATED);
	}
}
