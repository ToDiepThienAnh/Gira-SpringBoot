package cybersoft.backend.java11.gira.user.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.backend.java11.gira.user.utils.UserStatus;

public class CreateUserDto {
	@NotBlank(message = "{user.username.notblank}")
	@Size(min = 3, max = 50, message = "{user.username.size}")
	@Column(unique = true)
	private String username;
	
	@NotBlank(message = "{user.password.notblank}")
	private String password;
	
	@NotBlank(message = "{user.displayName.notblank}")
	private String displayName;
	
	@NotBlank(message = "{user.fullname.notblank}")
	private String fullName;
	
	@NotBlank(message = "{user.email.notblank}")
	@Email
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;

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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	
}
