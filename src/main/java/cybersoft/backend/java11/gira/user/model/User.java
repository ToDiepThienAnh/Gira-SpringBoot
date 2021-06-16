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
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getFacebookUrl() {
		return facebookUrl;
	}
	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
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
