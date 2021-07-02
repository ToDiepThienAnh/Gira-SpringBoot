package cybersoft.backend.java11.gira.project.service;

import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.backend.java11.gira.project.dto.CreateProjectTypeDto;
import cybersoft.backend.java11.gira.project.model.ProjectType;
import cybersoft.backend.java11.gira.project.repository.ProjectTypeRepository;
import cybersoft.backend.java11.gira.utils.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectTypeServiceimpl extends GenericServiceImpl<ProjectType, Long> implements ProjectTypeService {
	private ProjectTypeRepository repository;
	private MapDtoToModel<Object, Object> mapper;
	
	@Override
	public ProjectType save(CreateProjectTypeDto dto) {
		ProjectType type = new ProjectType();
		type = (ProjectType) mapper.map(dto, type);
		repository.save(type);
		return type;
	}

}
