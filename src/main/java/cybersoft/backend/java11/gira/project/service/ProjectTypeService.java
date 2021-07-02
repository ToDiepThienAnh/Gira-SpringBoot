package cybersoft.backend.java11.gira.project.service;

import javax.validation.Valid;

import cybersoft.backend.java11.gira.commondata.GenericService;
import cybersoft.backend.java11.gira.project.dto.CreateProjectTypeDto;
import cybersoft.backend.java11.gira.project.model.ProjectType;

public interface ProjectTypeService extends GenericService<ProjectType, Long> {

	ProjectType save(CreateProjectTypeDto dto);

}
