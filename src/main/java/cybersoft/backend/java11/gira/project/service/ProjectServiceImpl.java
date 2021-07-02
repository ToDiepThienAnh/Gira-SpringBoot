package cybersoft.backend.java11.gira.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.backend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.backend.java11.gira.project.model.Project;
import cybersoft.backend.java11.gira.project.model.ProjectType;
import cybersoft.backend.java11.gira.project.repository.ProjectRepository;
import cybersoft.backend.java11.gira.project.repository.ProjectTypeRepository;
import cybersoft.backend.java11.gira.user.model.User;
import cybersoft.backend.java11.gira.user.repository.UserRepository;
import cybersoft.backend.java11.gira.utils.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long> implements ProjectService {
	private ProjectRepository repository;
	private MapDtoToModel<Object, Object> mapper;
	private ProjectTypeRepository projectTypeRepository;
	private UserRepository userRepository;
	
	@Override
	public Project save(CreateProjectDto dto) {
		// TODO Auto-generated method stub
		Project project = new Project();
		project = (Project) mapper.map(dto, project);
		ProjectType type = projectTypeRepository.getOne(dto.getProjectTypeId());
		project.setProjectType(type);
		User owner = userRepository.getOne(dto.getOwnerId());
		User manager = userRepository.getOne(dto.getManagerId());
		project.setManager(manager);
		project.setOwner(owner);
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
