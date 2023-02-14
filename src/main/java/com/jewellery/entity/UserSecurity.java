package com.jewellery.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSecurity implements UserDetails {

	private final User users;

	public UserSecurity(User users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(users.getRole().split(",")).map(SimpleGrantedAuthority::new).toList();
	}

	// this method is use for fetching password
	@Override
	public String getPassword() {
		return users.getPassword();
	}

	// this method is use for fetching User name
	@Override
	public String getUsername() {
		return users.getUsername();
	}

	// check whether AccountNonExpired function is true or false
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
