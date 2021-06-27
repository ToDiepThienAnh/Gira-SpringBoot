package cybersoft.backend.java11.gira.project.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;
import cybersoft.backend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_project")
public class Project extends AbstractEntity {
	@NotBlank(message = "{project.name.not-blank}")
	@Size(min = 3, max = 100, message = "{project.name.size}")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "{project.code.not-blank}")
	@Size(min = 3, max = 7, message = "{project.code.size}")
	@Column(unique = true)
	private String code;
	/*
	 * Cybersoft Gira Education Project
	 * CGEP
	 * CGEP-4
	 */
	
	private String icon;
	
	@NotBlank(message = "{project.description.not-blank}")
	private String description;
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	// redundant code -> Dốt mà hay nói chữ
	// bidirectional
	// ManyToOne, OneToMany, OneToOne: EAGER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "username")
	private User owner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "username")
	private User manager;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private ProjectType projectType; // PRODUCT, MAINTAIN, SERVICE / 1, 2, 3
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<Workflow> workflows;
}
