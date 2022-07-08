//package com.capg.springboot.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.capg.springboot.Exceptions.CustomerNotFoundException;
//import com.capg.springboot.entity.Customer;
//import com.capg.springboot.repository.CustomerRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CustomerServiceTest {
//
//	@InjectMocks
//	private CustomerServiceImpl cust_ser;
//	
//	@Mock
//	private CustomerRepository cust_repo;
//	
//	@Test
//	public void addCustomerTest() throws CustomerNotFoundException{
//		System.out.println("hello");
//		
//		  Customer cust = new Customer();
//		  
//		  cust.setCustomerId("121"); cust.setEmail("test@gmail");			
//		  cust.setFirstName("sravan");
//		  
//		  Mockito.doReturn(cust).when(cust_repo).findByCustomerId(Mockito.any());
//		  
//		  assertEquals(cust.getCustomerId(),cust_ser.findByCustomerId(cust).getCustomerId());
//		  
//		 
//	}
//	
//	
//}
