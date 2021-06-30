package cybersoft.backend.java11.gira.project.service;


import javax.validation.Valid;

import cybersoft.backend.java11.gira.commondata.GenericService;
import cybersoft.backend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.backend.java11.gira.project.model.Project;

public interface ProjectService extends GenericService<Project, Long> {

	Project save(CreateProjectDto dto);


	Project update(CreateProjectDto project, Long id);

}
