package com.jewellery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.jewellery.entity.User;
import com.jewellery.repository.UserRepository;

@Component
public class AdminUserInitializer implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// Create admin users
		User adminUser1 = new User();
		String encryptedPassword1 = new BCryptPasswordEncoder().encode("ahir");
		adminUser1.setUsername("Abinash");
		adminUser1.setPassword(encryptedPassword1);
		adminUser1.setRole("ROLE_ADMIN");
		adminUser1.setFirstName("Abinash");
		adminUser1.setLastName("Ahir");
		adminUser1.setEmail("ahirabinash@gmail.com");
		adminUser1.setPhoneNumber("8457823790");
		adminUser1.setAddress("Banglore");

		
		
		User adminUser2 = new User();
		String encryptedPassword2 = new BCryptPasswordEncoder().encode("Vidya25");
		adminUser2.setUsername("Vidya");
		adminUser2.setPassword(encryptedPassword2);
		adminUser2.setRole("ROLE_ADMIN");
		adminUser2.setFirstName("Vidya");
		adminUser2.setLastName("Kharvi");
		adminUser2.setEmail("Vidya@gmail.com");
		adminUser2.setPhoneNumber("8457898790");
		adminUser2.setAddress("Banglore");
		
		User adminUser3 = new User();
		String encryptedPassword3 = new BCryptPasswordEncoder().encode("chandu27");
		adminUser3.setUsername("Chandana");
		adminUser3.setPassword(encryptedPassword3);
		adminUser3.setRole("ROLE_ADMIN");
		adminUser3.setFirstName("Chandna");
		adminUser3.setLastName("K S");
		adminUser3.setEmail("Chanduks027@gmail.com");
		adminUser3.setPhoneNumber("7899345287");
		adminUser3.setAddress("Hassan");
		
		User adminUser4= new User();
		String encryptedPassword4 = new BCryptPasswordEncoder().encode("Mounik@3320");
		adminUser4.setUsername("MounikaMarla");
		adminUser4.setPassword(encryptedPassword4);
		adminUser4.setRole("ROLE_ADMIN");
		adminUser4.setFirstName("Mounika");
		adminUser4.setLastName("Marla");
		adminUser4.setEmail("marlamounika07@gmail.com");
		adminUser4.setPhoneNumber("9652365180");
		adminUser4.setAddress("Banglore");
		
		User adminUser5 = new User();
		String encryptedPassword5 = new BCryptPasswordEncoder().encode("Raghu@2001");
		adminUser5.setUsername("Vijayabaskaran");
		adminUser5.setPassword(encryptedPassword5);
		adminUser5.setRole("ROLE_ADMIN");
		adminUser5.setFirstName("Vijayabaskaran");
		adminUser5.setLastName("G");
		adminUser5.setEmail("raghuvijay1629@gmail.com");
		adminUser5.setPhoneNumber("6369075050");
		adminUser5.setAddress("Banglore");
		
		User adminUser6 = new User();
		String encryptedPassword6 = new BCryptPasswordEncoder().encode("shubham123");
		adminUser6.setUsername("shubham");
		adminUser6.setPassword(encryptedPassword6);
		adminUser6.setRole("ROLE_ADMIN");
		adminUser6.setFirstName("Shubham");
		adminUser6.setLastName("Raj");
		adminUser6.setEmail("shubham2@gmail.com");
		adminUser6.setPhoneNumber("9523813880");
		adminUser6.setAddress("Banglore");


		// Save the admins to the database
		userRepository.save(adminUser1);
		userRepository.save(adminUser2);
		userRepository.save(adminUser3);
		userRepository.save(adminUser4);
		userRepository.save(adminUser5);
		userRepository.save(adminUser6);
	}
}
