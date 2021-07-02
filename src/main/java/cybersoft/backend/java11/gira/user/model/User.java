package cybersoft.backend.java11.gira.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;
import cybersoft.backend.java11.gira.project.model.Project;
import cybersoft.backend.java11.gira.role.model.RoleGroup;
import cybersoft.backend.java11.gira.user.utils.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_user")
public class User extends AbstractEntity {
	@NotBlank(message = "{user.username.notblank}")
	@Size(min = 3, max = 50, message = "{user.username.size}")
	@Column(unique = true, name = "username")
	private String username;
	
	@NotBlank(message = "{user.password.notblank}")
	private String password;
	@NotBlank
	private String fullName;
	@NotBlank(message = "{}")
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	private String displayName;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	private String avatar;
	private String facebookUrl;
	private String job;
	private String department;
	private String hobbies;
	
	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<RoleGroup> roleGroups = new HashSet<>();
	
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Project> ownProjects = new HashSet<>();
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private Set<Project> manageProjects = new HashSet<>();
}
