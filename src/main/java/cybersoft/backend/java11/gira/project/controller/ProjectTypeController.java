package cybersoft.backend.java11.gira.project.controller;

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
import cybersoft.backend.java11.gira.project.dto.CreateProjectTypeDto;
import cybersoft.backend.java11.gira.project.model.ProjectType;
import cybersoft.backend.java11.gira.project.service.ProjectTypeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/project/type")
public class ProjectTypeController {
	private ProjectTypeService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllProjectType(){
		List<ProjectType> list = service.findAll();
		
		if(list.isEmpty())
			return ResponseHandler.getResponse("there is no data", HttpStatus.OK);
		return ResponseHandler.getResponse(list, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNewProjectType(@Valid @RequestBody CreateProjectTypeDto dto,
			BindingResult errors){
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.OK);
		ProjectType type = service.save(dto);
		return ResponseHandler.getResponse(type, HttpStatus.CREATED);
	}
	
	
}
