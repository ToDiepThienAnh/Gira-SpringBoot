package cybersoft.backend.java11.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CreateRoleGroupDTO {
	@NotBlank(message = "group name can't be blank.")
	@Size(min = 4, max = 50, message = "{role-group.name.size}")
	public String groupName;
	
	@NotBlank(message = "group description can't be blank.")
	public String description;
}
