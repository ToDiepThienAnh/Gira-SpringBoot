package cybersoft.backend.java11.gira.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.backend.java11.gira.user.dto.CreateUserDto;
import cybersoft.backend.java11.gira.user.model.User;
import cybersoft.backend.java11.gira.user.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public User save(CreateUserDto dto) {
		// TODO Auto-generated method stub
		User user = new User().username(dto.getUsername())
							.password(dto.getPassword())
							.displayName(dto.getDisplayName())
							.email(dto.getEmail())
							.fullName(dto.getFullName())
							.status(dto.getStatus());
		return repository.save(user);
	}

}
