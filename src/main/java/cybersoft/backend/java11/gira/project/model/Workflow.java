package cybersoft.backend.java11.gira.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;

@Entity
@Table(name = "gira_workflow")
public class Workflow extends AbstractEntity {
	private String name;
	private String description;
	
	@Column(name = "project_id")
	private Long projectId;
	
	@ManyToOne()
	@JoinColumn(name = "project_id", insertable = false, updatable = false)
	private Project project;
	
	@OneToMany(mappedBy = "workflow", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<WorkflowNode> nodes;
	
	@OneToMany(mappedBy = "workflow", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<WorkflowLink> links;
}
