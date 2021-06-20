package cybersoft.backend.java11.gira.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.backend.java11.gira.user.utils.UserStatus;
import cybersoft.backend.java11.gira.user.validation.annotation.ConfirmPassword;
import cybersoft.backend.java11.gira.user.validation.annotation.UniqueUserName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfirmPassword(message = "{user.confirm-password}")
public class CreateUserDTO {
	@NotBlank(message = "aa")
	@Size(min = 3, max = 50, message = "aa")
	@UniqueUserName
	private String username;
	
	@NotBlank(message = "aa")
	@Size(min = 8, max = 100, message = "aa")
	private String password;
	
	@NotBlank(message = "aa")
	private String confirmPassword;
	
	@NotBlank(message = "aa")
	private String fullName;
	@NotBlank(message = "aa")
	@Email
	private String email;
	@NotBlank(message = "aa")
	private String displayName;
	@NotNull
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	
	
}
