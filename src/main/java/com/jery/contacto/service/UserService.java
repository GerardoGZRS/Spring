package com.jery.contacto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jery.contacto.entity.User;
import com.jery.contacto.entity.UserRole;
import com.jery.contacto.repository.UserRepository;

@EnableJpaRepositories(basePackages = { "com.jery.contacto.repository" })
@EntityScan(value = { "com.jery.contacto.entity" })
@Service("userService")
public class UserService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return  buildUser(user, authorities);
	}

	/*
	private User buildUser(User, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnable(),
				true, true, true, authorities);
	}
	
*/
	
	private org.springframework.security.core.userdetails.User buildUser(com.jery.contacto.entity.User user, List<GrantedAuthority> authorities){
		return new 
org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnable(),
		true, true, true, authorities);
		
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for(UserRole role : userRole) {
			auths.add(new SimpleGrantedAuthority(role.getRole()));
			
		}
		
		return new ArrayList<GrantedAuthority>(auths);
	}
}
