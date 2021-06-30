package cybersoft.backend.java11.gira.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.backend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.backend.java11.gira.project.model.Project;
import cybersoft.backend.java11.gira.project.repository.ProjectRepository;

@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long> implements ProjectService {
	@Autowired
	private ProjectRepository repository;
	
	@Override
	public Project save(CreateProjectDto dto) {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setName(dto.getName());
		project.setCode(dto.getCode());
		project.setDescription(dto.getDescription());
		repository.save(project);
		return project;
	}

	@Override
	public Project update(CreateProjectDto project, Long id) {
		// TODO Auto-generated method stub
		Project projectUpdate = repository.getOne(id);
		projectUpdate.setName(project.getName());
		projectUpdate.setCode(project.getCode());
		projectUpdate.setDescription(project.getDescription());
		return repository.save(projectUpdate);
	}

}
