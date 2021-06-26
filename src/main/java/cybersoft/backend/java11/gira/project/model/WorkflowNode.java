package cybersoft.backend.java11.gira.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gira_workflow_node")
public class WorkflowNode {
	private String name;
	private String code;
	private int nodeOrder;
	
	@Column(name = "workflow_id")
	private Long workflowId;
	
	@ManyToOne
	@JoinColumn(name = "workflow_id", insertable = false, updatable = false)
	private Workflow workflow;
}
