package cybersoft.backend.java11.gira.user.service;


import cybersoft.backend.java11.gira.commondata.GenericService;
import cybersoft.backend.java11.gira.user.dto.CreateUserDTO;
import cybersoft.backend.java11.gira.user.model.User;

public interface UserService extends GenericService<User, Long> {
	public User save(CreateUserDTO dto);
	public boolean isTakenUsername(String username);
}
