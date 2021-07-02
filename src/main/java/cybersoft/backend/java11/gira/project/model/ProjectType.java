package cybersoft.backend.java11.gira.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_project_type")
public class ProjectType extends AbstractEntity {
	@NotBlank(message = "{project-type.name.not-blank}")
	@Size(min = 3, max = 100, message = "{project-type.name.size}")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "{project-type.code.not-blank}")
	@Size(min = 3, max = 10, message = "{project-type.code.size}")
	private String code;
	
	// MAINTAIN, SERVICE, PRODUCT
	
	private String description;
	
	@OneToMany(mappedBy = "projectType", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Project> projects = new HashSet<Project>();
}
