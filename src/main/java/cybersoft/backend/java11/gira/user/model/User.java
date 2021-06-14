package cybersoft.backend.java11.gira.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.backend.java11.gira.commondata.AbstractEntity;
import cybersoft.backend.java11.gira.user.utils.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gira_user")
@Getter
@Setter
public class User extends AbstractEntity {
	@NotBlank(message = "{user.username.notblank}")
	@Size(min = 3, max = 50, message = "{user.username.size}")
	@Column(unique = true)
	private String username;
	
	@NotBlank(message = "{user.password.notblank}")
	private String password;
	@NotBlank
	private String fullName;
	@NotBlank(message = "{}")
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank(message = "{}")
	private String displayName;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	private String avatar;
	private String facebookUrl;
	private String job;
	private String department;
	private String hobbies;
	
	public User username(String username) {
		this.username = username;
		return this;
	}
	public User fullname(String fullname) {
		this.fullName = fullname;
		return this;
	}
	public User status(UserStatus status) {
		this.status = status;
		return this;
	}
	public User displayName(String displayName) {
		this.displayName = displayName;
		return this;
	}
	public User password(String password) {
		this.password = password;
		return this;
	}
	
	public User email(String email) {
		this.email = email;
		return this;
	}
}
