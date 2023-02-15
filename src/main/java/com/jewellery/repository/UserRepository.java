package com.jewellery.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jewellery.entity.Product;
import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	

}
