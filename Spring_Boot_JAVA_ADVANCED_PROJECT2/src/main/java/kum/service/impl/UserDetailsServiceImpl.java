package kum.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kum.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository repository;
	
	
	
	public UserDetailsServiceImpl(UserRepository repository) {
		this.repository = repository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		kum.entity.User entity = repository.findByEmail(username);
		if (entity == null) {
			throw new UsernameNotFoundException("User with login/email " + username + " not exist");
		}
		return new User(username, entity.getPassword(), AuthorityUtils.createAuthorityList(entity.getRole().name()));
	
	}

}
