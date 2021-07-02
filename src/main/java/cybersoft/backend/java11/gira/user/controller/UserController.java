package cybersoft.backend.java11.gira.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.backend.java11.gira.commondata.ResponseHandler;
import cybersoft.backend.java11.gira.user.dto.CreateUserDto;
import cybersoft.backend.java11.gira.user.model.User;
import cybersoft.backend.java11.gira.user.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
	private UserService service;
	
	
	@GetMapping("")
	public ResponseEntity<Object> findAllUser(){
		List<User> list = service.findAll();
		if(list.isEmpty())
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
		return ResponseHandler.getResponse(list, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNewUser(@Valid @RequestBody CreateUserDto dto,
			BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		User user = service.save(dto);
		return ResponseHandler.getResponse(user, HttpStatus.CREATED);
	}
}
