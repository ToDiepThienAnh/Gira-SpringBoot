package cybersoft.backend.java11.gira.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;

@Entity
@Table(name = "gira_project_type")
public class ProjectType extends AbstractEntity {
	@NotBlank
	private String name;
	
	@NotBlank
	private String code;
	
	@NotBlank
	private String description;
	
	@OneToMany(mappedBy = "projectType", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Project> projects;
}
