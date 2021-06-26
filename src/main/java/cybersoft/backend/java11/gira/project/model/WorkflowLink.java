package cybersoft.backend.java11.gira.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;

@Entity
@Table(name = "gira_workflow_link")
public class WorkflowLink extends AbstractEntity {
	private WorkflowNode linkBy; // source
	private WorkflowNode linkTo; // destination
	@NotBlank
	private String transition;
	
	@Column(name = "workflow_id")
	private Long workflowId;
	
	@ManyToOne
	@JoinColumn(name = "workflow_id", insertable = false, updatable = false)
	private Workflow workflow;
}
