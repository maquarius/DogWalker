package com.BITe.DogWalker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BITe.DogWalker.domain.UserPerson;
import com.BITe.DogWalker.domain.UserPersonRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserPersonRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserPersonRepository userRepository) {
		this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPerson curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}

}
