package cybersoft.backend.java11.gira.user.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.backend.java11.gira.user.utils.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
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
}
