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

import cybersoft.backend.java11.gira.commondata.ResponseHandler;
import cybersoft.backend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.backend.java11.gira.project.model.Project;
import cybersoft.backend.java11.gira.project.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllProjects(){
		List<Project> projects = service.findAll();
		if(projects.isEmpty())
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
		return ResponseHandler.getResponse(projects, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createNewProject(@Valid @RequestBody CreateProjectDto dto,
												BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		Project project = service.save(dto);
		return ResponseHandler.getResponse(project, HttpStatus.OK);
	}
	
	@PutMapping("/{project-id}")
	public ResponseEntity<Object> createNewProject(@Valid @RequestBody CreateProjectDto project,
					@PathVariable("project-id") Long id,
					BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		Project res = service.update(project, id);
		return ResponseHandler.getResponse(res, HttpStatus.OK);
	}
	
}
