package cybersoft.backend.java11.gira.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;

@Entity
@Table(name = "gira_project_workflow_node")
public class WorkflowNode extends AbstractEntity {
	@NotBlank(message = "{workflow-node.name.not-blank}")
	@Size(min = 3, max = 100, message = "{workflow-node.name.size}")
	private String name;
	
	private int nodeOrder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Workflow workflow;
	
	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
	private Set<WorkflowLink> linkBy = new HashSet<>();
	
	@OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
	private Set<WorkflowLink> linkTo = new HashSet<>();
}
