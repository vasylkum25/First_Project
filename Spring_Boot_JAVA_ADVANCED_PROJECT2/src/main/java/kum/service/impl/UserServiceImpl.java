package kum.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kum.entity.Role;
import kum.entity.User;
import kum.model.request.RegistrationRequest;
import kum.repository.UserRepository;
import kum.service.UserService;

@Service 
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	
	private final PasswordEncoder encoder;
	
	public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}



	@Override
	public void save(RegistrationRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(Role.ROLE_CAFE);
		repository.save(user);
	}

}
