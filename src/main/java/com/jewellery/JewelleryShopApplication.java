package com.jewellery;

import java.util.Collections;

import javax.management.relation.Role;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jewellery.entity.User;
import com.jewellery.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class JewelleryShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JewelleryShopApplication.class, args);
	}

}
                                                                                                                     