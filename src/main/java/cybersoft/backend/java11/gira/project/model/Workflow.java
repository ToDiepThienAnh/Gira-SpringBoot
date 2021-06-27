package cybersoft.backend.java11.gira.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_project_workflow")
public class Workflow extends AbstractEntity {
	@NotBlank(message = "{workflow.name.not-blank}")
	@Size(min = 3, max = 100, message = "{workflow.name.size}")
	private String name;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;
	
	@OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<WorkflowNode> nodes;
	
	@OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<WorkflowLink> links;
	
}
