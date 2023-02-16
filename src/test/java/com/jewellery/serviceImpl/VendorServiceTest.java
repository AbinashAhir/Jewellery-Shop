package com.jewellery.serviceImpl;
	
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.doNothing;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import org.junit.jupiter.api.DisplayName;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;


	import com.jewellery.entity.Product;
import com.jewellery.exception.DuplicateItemException;
import com.jewellery.repository.ProductRepository;
	import com.jewellery.serviceImpl.VendorServiceImpl;

	@ExtendWith(MockitoExtension.class)
	public class VendorServiceTest {
		
		@InjectMocks
		VendorServiceImpl vendorServiceImpl;
		
		@Mock
		private ProductRepository productRepository;
		
		@Test
		void addProductTest() {
			Product product =createProductMockData();
			when(productRepository.save(product)).thenReturn(product);
			String response = null;
			try {
				response = vendorServiceImpl.addProduct(product);
			} catch (DuplicateItemException e) {
		
				e.printStackTrace();
			}
			assertEquals(response, "Product Added Successfully");
		}
		
//		@Test
//		void deleteProduct() {
//			int ProductId =1;
//			doNothing().when(productRepository).deleteById(ProductId);
//			String response =  vendorServiceImpl.deleteProduct(ProductId);
//			assertEquals(response, "Product Deleted");
//		}
		
		
		
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
		
		
		

	}


