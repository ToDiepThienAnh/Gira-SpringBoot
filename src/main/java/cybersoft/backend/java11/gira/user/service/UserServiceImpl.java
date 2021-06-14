package cybersoft.backend.java11.gira.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.backend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.backend.java11.gira.user.dto.CreateUserDTO;
import cybersoft.backend.java11.gira.user.model.User;
import cybersoft.backend.java11.gira.user.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	
	@Autowired
	private UserRepository _repository;
	
	@Override
	public User save(CreateUserDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("Run in CreateUserDTO");
		User user = new User().username(dto.getUsername())
				.password(dto.getPassword())
				.displayName(dto.getDisplayName())
				.status(dto.getStatus())
				.fullname(dto.getFullName())
				.email(dto.getEmail());
		return _repository.save(user);
	}

	@Override
	public boolean isTakenUsername(String username) {
		// TODO Auto-generated method stub
		return _repository.countByUsername(username) >= 1;
	}
}
