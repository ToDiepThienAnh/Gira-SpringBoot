package cybersoft.backend.java11.gira.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.backend.java11.gira.role.dto.CreateRoleGroupDTO;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.model.RoleGroup;
import cybersoft.backend.java11.gira.role.service.RoleGroupServiceInf;

@RestController
@RequestMapping("/api/role-group")
public class RoleGroupController {
	@Autowired
	private RoleGroupServiceInf _service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllGroup(){
		List<RoleGroup> list = _service.findAll();
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveRoleGroup(@Valid @RequestBody CreateRoleGroupDTO dto, BindingResult errors){
		if(errors.hasErrors()) {
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		RoleGroup group = new RoleGroup().name(dto.groupName).description(dto.description);
		_service.save(group);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{group-id}/role")
	public ResponseEntity<Object> addRoleToGroup(@Valid @RequestBody Role role,
			@PathVariable("group-id") Long groupId,
			BindingResult errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<>(errors.getAllErrors(),HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
}
