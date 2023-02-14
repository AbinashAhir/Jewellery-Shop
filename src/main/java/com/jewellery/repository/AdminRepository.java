package com.jewellery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jewellery.entity.Billing;
import com.jewellery.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Long>{
	
}
