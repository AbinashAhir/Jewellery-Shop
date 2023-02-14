package com.jewellery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jewellery.entity.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long>{
//	List<Billing> findAll();
}
