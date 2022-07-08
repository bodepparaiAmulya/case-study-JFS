//package com.capg.springboot.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.capg.springboot.entity.Product;
//import com.capg.springboot.repository.ProductRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProdServiceTest {
//
//	@InjectMocks
//	private ProductServiceImpl prod_ser;
//	
//	@Mock
//	private ProductRepository pro_repo;
//
//	@Test
//	public void addProductTest1() {
//		Product product=new Product();
//	    product.setColor("red");
//	    product.setDimension("square");
//	    product.setManufacturer("nokia");
//	    
//	    Mockito.when(pro_repo.save(product)).thenReturn(product);
//	}
//	
//}
