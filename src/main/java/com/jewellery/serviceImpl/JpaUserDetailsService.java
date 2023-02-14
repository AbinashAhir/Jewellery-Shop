package com.jewellery.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.jewellery.entity.UserSecurity;
import com.jewellery.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JpaUserDetailsService implements UserDetailsService {
	private final UserRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usersRepository.findByUsername(username).map(UserSecurity::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
	}
}
