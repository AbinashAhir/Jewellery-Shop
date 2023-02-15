package com.jewellery.controller;
	
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertNotNull;
	import static org.mockito.Mockito.when;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.jupiter.api.DisplayName;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

	import com.jewellery.entity.Billing;
	import com.jewellery.entity.Feedback;
	import com.jewellery.entity.Product;
	import com.jewellery.entity.Purchase;
	import com.jewellery.entity.User;
	import com.jewellery.repository.BillingRepository;
	import com.jewellery.repository.FeedbackRepository;
	import com.jewellery.repository.ProductRepository;
	import com.jewellery.repository.PurchaseRepository;
	import com.jewellery.serviceImpl.AdminServiceImpl;
	import com.jewellery.serviceImpl.CustomerServiceImpl;


	@ExtendWith(MockitoExtension.class)
	public class CustomerControllerTest {
		
		@InjectMocks
		private CustomerServiceImpl customerServiceimpl;
		
		@InjectMocks
		private AdminServiceImpl adminServiceimpl;
		
		@Mock
		private ProductRepository productrepository;
		
		@Mock
		private FeedbackRepository feedbackrepository;
		
		@Mock
		private BillingRepository billingrepository;
		
		@Mock
		private PurchaseRepository purchaserepository;
		

				@Test
				void getAllProductByProductName() {
					String productName="Name";
					Product product =createProductMockData();
					when(productrepository.findByProductName(productName)).thenReturn(Optional.of(product));
					Product response =customerServiceimpl.getAllProductByProductName(productName);
					assertEquals(response.getProductName(),product.getProductName());
					
		}

				
				@Test
				void getAllProductByProductId() {
					int productId=1;
					Product product=createProductMockData();
					when(productrepository.findById(productId)).thenReturn(Optional.of(product));
					Product response=customerServiceimpl.getProductById(productId);
					assertEquals(response.getProductId(),product.getProductId());
							
				}
				
				
				@Test
				void getAllProductTest() {
					List<Product> product = new ArrayList();
					product.add(createProductMockData());
					when(productrepository.findAll()).thenReturn(product);
					List<Product> allProducts = customerServiceimpl.getAllProduct();
					assertNotNull(allProducts);
					assertEquals(allProducts.size(),1);
				}
				

				
//		@Override
//		public Purchase getPurchaseById(int purchaseId) {
//			Optional<Purchase> purchaseById = purchaseRepository.findById(purchaseId);
//			Purchase purchase = purchaseById.get();
//			return purchase;
//		}
//		
//				@Test
//				void getPurchaseByProductId() {
//					int purchaseId=1;
//					Purchase purchase=createPurchaseMockData();
//					when(purchaserepository.findById(purchaseId)).thenReturn(purchase);
//					Product response=customerServiceimpl.getProductById(purchaseId);
//					assertEquals(response.getPurchaseId(),purchase.getPurchaseId());
//							
//				}
//				
//				
		
					
		            private Feedback createFeedbackMockData() {
					Feedback feedback =new Feedback();
					feedback.setFeedback("Excellent");
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
					User user=new User();
					user.setId(1);
					user.setFirstName("first Name");
					user.setLastName("last name");
					user.setEmail("email");
					user.setAddress("address");
					user.setPassword("password");
					user.setPhoneNumber(9L);
					user.setRole("USER");
					return user;
							}

	}



