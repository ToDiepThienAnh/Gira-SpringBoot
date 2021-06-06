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

import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.service.RoleService;
import cybersoft.backend.java11.gira.role.service.RoleServiceInf;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private RoleServiceInf _service;
	
//	@GetMapping("")
//	public ResponseEntity<Object> findAll(){
//		List<Role> roles = _service.findAll();
//		
//		if(roles.isEmpty() ) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(roles, HttpStatus.OK);
//	}
//	
//	@GetMapping("/with-account")
//	public ResponseEntity<List<RoleWithAccountsDTO>> findRoleWithAccountInfo(){
//		List<RoleWithAccountsDTO> roles = _service.findRoleWithAccountInfo();
//		
//		if(roles.isEmpty())
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		
//		return new ResponseEntity<>(roles, HttpStatus.OK);
//	}
//	
//	@GetMapping("/description/{role-name}")
//	public ResponseEntity<Object> findRoleWithoutBlankDescription(@PathVariable("role-name") String roleName){
//		List<Role> roles = _service.findRoleWithoutBlankDescription(roleName);
//		
//		if(roles.isEmpty())
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		
//		return new ResponseEntity<>(roles, HttpStatus.OK);
//	}
//	
//	@GetMapping("/{role-name}")
//	public ResponseEntity<Object> findByRoleName(@PathVariable("role-name") String roleName){
//		List<Role> roles = _service.findByRoleName(roleName);
//		
//		if(roles == null ) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(roles, HttpStatus.OK);
//	}
//	
//	@GetMapping("/description")
//	public ResponseEntity<Object> findByDescription(@RequestParam("description") String description){
//		List<Role> roles = _service.findByDescription(description);
//		
//		if(roles.isEmpty())
//			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//		
//		return new ResponseEntity<Object>(roles, HttpStatus.OK);
//	}
//	
//	@PostMapping("")
//	public ResponseEntity<Object> save(@RequestBody Role role){
//		try {
//			System.out.println(role);
//			_service.save(role);
//			return new ResponseEntity<>(HttpStatus.CREATED);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//	}
}
