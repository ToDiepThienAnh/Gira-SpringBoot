package cybersoft.backend.java11.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateRoleDTO {
	@NotBlank(message = "{role.name.notblank}")
	@Size(min = 4, max = 50, message = "{role.name.size}")
	public String roleName;
	
	@NotBlank(message = "{role.description.notblank}")
	public String description;
}
