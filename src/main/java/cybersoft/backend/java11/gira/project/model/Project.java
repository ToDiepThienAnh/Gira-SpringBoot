package cybersoft.backend.java11.gira.project.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;
import cybersoft.backend.java11.gira.user.model.User;

@Entity
@Table(name = "gira_project")
public class Project extends AbstractEntity {
	@NotBlank
	private String name;
	
	@NotBlank
	private String code;
	
	private User owner;
	
	private User manager;
	private String icon;
	private String description;
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@Column(name = "project_type_id", insertable = false, updatable = false)
	private Long project_type_id;
	
	@ManyToOne
	@JoinColumn(name = "project_type_id")
	private ProjectType projectType;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Workflow> workflows;
	
}
