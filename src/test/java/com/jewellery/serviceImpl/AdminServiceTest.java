package com.jewellery.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.Product;
import com.jewellery.entity.Purchase;
import com.jewellery.entity.User;
import com.jewellery.repository.BillingRepository;
import com.jewellery.repository.FeedbackRepository;
import com.jewellery.repository.UserRepository;
import com.jewellery.serviceImpl.AdminServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

	@InjectMocks
	private AdminServiceImpl adminServiceimpl;
	
	

	@Mock
	private FeedbackRepository feedbackrepository;

	@Mock
	private UserRepository userrepository;
	
	@Mock
	private BillingRepository billingrepository;
	

	@Test
	void addVendorTest() {
		User user = createUserMockData();
		when(userrepository.save(user)).thenReturn(user);
		String response = adminServiceimpl.addVendor(user);
		assertEquals(response, "Vendor added successfully");

	}
	
	@Test
	void deleteVendor() {
		int userId =1;
		doNothing().when(userrepository).deleteById(userId);
		String response =  adminServiceimpl.deleteVendor(userId);
		assertEquals(response, "Vendor deleted successfully");
	}
		
	
//	@PutMapping("/updateVendor")
//	public String updateVendor(@RequestBody User user) {
//		adminService.updateVendor(user);
//		return "Vendor updated sucessfully";
//	}
//	
//	@Test
//	@DisplayName("Update Student")
//	void updateStudentTest() {
//		Student student = createStudentMockData();
//		when(studentRepository.save(student)).thenReturn(student);
//		Student response = studentService.updateStudent(student);
//		assertEquals(response.getName(), student.getName());
//	}
	


	@Test
	@DisplayName("Update Vendor")
	void updateVendorTest() {
		User user = createUserMockData();
		when(userrepository.save(user)).thenReturn(user);
		String response = adminServiceimpl.updateVendor(user);
		assertEquals(response,"Vendor updated");
	}
	
	
	
	@Test
	@DisplayName("Get All Feedback")
	void getAllFeedbackTest() {
		List<Feedback> feedback = new ArrayList();
		feedback.add(createFeedbackMockData());
		when(feedbackrepository.findAll()).thenReturn(feedback);
		List<Feedback> allFeedback = adminServiceimpl.getAllFeedback();
		assertNotNull(allFeedback);
		assertEquals(allFeedback.size(), 1);
	}
	
			
		@Test
        void getBillTest() {
		List<Billing> billing =new ArrayList();
		billing.add(createBillingMockData());
		when(billingrepository.findAll()).thenReturn(billing);
		List<Billing> allbilling = adminServiceimpl.getAllBill();
		assertNotNull(allbilling);
		assertEquals(allbilling.size(), 1);
	}
	
	private Billing createBillingMockData() {
			Billing billing = new Billing();
			billing.setId(1);
			billing.setPurchase(createPurchaseMockData());
			billing.setUser(createUserMockData());
			billing.setTotalCost(5000);
			return billing;
		}

	private Feedback createFeedbackMockData() {
		Feedback feedback = new Feedback();
		feedback.setFeedback("Good");
		feedback.setId(1);
		feedback.setProduct(createProductMockData());
		feedback.setPurchase(createPurchaseMockData());
		feedback.setUser(createUserMockData());
		return feedback;
	}

	private Product createProductMockData() {
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("chain");
		product.setProductMaterial("gold");
		product.setProductWeight(23.4);
		product.setProductGmPerWeight(500);
		product.setProductQuantity(10);
		product.setProductCost(5000);
		return product;
	}

	private Purchase createPurchaseMockData() {
		Purchase purchase = new Purchase();
		purchase.setProduct(createProductMockData());
		purchase.setPurchaseId(1L);
		purchase.setQuantity(10L);
		purchase.setUser(createUserMockData());
		return purchase;
	}

	private User createUserMockData() {
		User user = new User();
		user.setId(1);
		user.setFirstName("first Name");
		user.setLastName("last name");
		user.setEmail("email");
		user.setAddress("address");
		user.setPassword("password");
		user.setPhoneNumber("9L");
		user.setRole("USER");
		return user;
	}

}