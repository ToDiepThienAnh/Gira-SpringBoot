package cybersoft.backend.java11.gira.user.service;

import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.backend.java11.gira.user.dto.CreateUserDto;
import cybersoft.backend.java11.gira.user.model.User;
import cybersoft.backend.java11.gira.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	private UserRepository repository;
	
	@Override
	public User save(CreateUserDto dto) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setFullName(dto.getFullName());
		user.setEmail(dto.getEmail());
		user.setStatus(dto.getStatus());
		user.setDisplayName(dto.getDisplayName());
		
		return repository.save(user);
	}

}
