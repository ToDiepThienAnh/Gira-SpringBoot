package cybersoft.backend.java11.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.backend.java11.gira.commondata.ResponseHandler;
import cybersoft.backend.java11.gira.commondata.ResponseObject;
import cybersoft.backend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.backend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.backend.java11.gira.role.model.Role;
import cybersoft.backend.java11.gira.role.service.RoleServiceInf;
import cybersoft.backend.java11.gira.utils.ErrorUtils;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private RoleServiceInf _service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAll(){
		List<Role> listRole = _service.findAll();
		
		if(listRole.isEmpty()) {
			return ResponseHandler.getResponse("No Content.", HttpStatus.NO_CONTENT);
		} 
		return ResponseHandler.getResponse(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/{role-name}")
	public ResponseEntity<Object> findByRoleName(@PathVariable("role-name") String roleName){
		List<Role> listRole = _service.findByRoleName(roleName);
		
		if(listRole.isEmpty()) {
			return ResponseHandler.getResponse("No Content.", HttpStatus.NO_CONTENT);
		} 
		return ResponseHandler.getResponse(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/description")
	public ResponseEntity<Object> findByDescriptionContainingOrderByIdAsc(@RequestParam("description")
					String description
			){
		List<Role> listRole = _service.findByDescriptionContainingOrderByIdAsc(description);
		
		if(listRole.isEmpty())
			return ResponseHandler.getResponse("No Content.", HttpStatus.NO_CONTENT);
		
		return ResponseHandler.getResponse(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/description/{role-name}")
	public ResponseEntity<Object> findRoleNameWidthDescriptionNotBlank(@PathVariable("role-name") String roleName){
		List<Role> listRole = _service.findRoleNameWidthDescriptionNotBlank(roleName);
		
		if(listRole.isEmpty())
			return ResponseHandler.getResponse("No Content.", HttpStatus.NO_CONTENT);
		
		return ResponseHandler.getResponse(listRole, HttpStatus.OK);
	}
	
	@GetMapping("/with-account")
	public ResponseEntity<Object> findAllWithAccount(){
		List<RoleWithAccountsDTO> list = _service.findAllWithAccount();
		
		if(list.isEmpty()) {
			return ResponseHandler.getResponse("No Content.", HttpStatus.NO_CONTENT);
		}
		return ResponseHandler.getResponse(list, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> save(@Valid @RequestBody CreateRoleDTO dto,
			BindingResult errors){
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		Role roleAdd = new Role();
		roleAdd.roleName(dto.roleName).description(dto.description);
		_service.save(roleAdd);
		return ResponseHandler.getResponse(roleAdd, HttpStatus.CREATED);
	}
	
	@PutMapping("/{role-id}")
	public ResponseEntity<Object> updateRoleInfo(
			@Valid @RequestBody CreateRoleDTO dto,
			@PathVariable("role-id") Long roleId,
			BindingResult errors){
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		Role updatedRole = _service.updateRoleInfo(dto, roleId);
		
		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);
	}
	
	@DeleteMapping("/{role-id}")
	public ResponseEntity<Object> deleteRoleById(@PathVariable("role-id")Long roleId){
		if(roleId == null)
			return ResponseHandler.getResponse("id is null", HttpStatus.BAD_REQUEST);
		
		_service.deleteById(roleId);
		return new ResponseEntity<>(
				new ResponseObject("Role has been deleted."),
				HttpStatus.OK
				);
	}
}
