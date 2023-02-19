package com.jewellery.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jewellery.dto.UserDTO;
import com.jewellery.entity.User;

@Component
public class UserConverter {

	public UserDTO entityToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setConfirmPassword(user.getConfirmPassword());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setAddress(user.getAddress());
		dto.setRole(user.getRole());

		return dto;
	}

	public List<UserDTO> entityToDTO(List<User> user) {
		return user.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}

	public User dtoToEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setConfirmPassword(dto.getConfirmPassword());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setAddress(dto.getAddress());
		user.setRole(dto.getRole());
		return user;
	}

	public List<User> dtoToEntity(List<UserDTO> dto) {

		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
