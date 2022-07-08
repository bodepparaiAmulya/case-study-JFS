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
//import com.capg.springboot.Exceptions.AddressNotFoundException;
//import com.capg.springboot.entity.Address;
//import com.capg.springboot.repository.AddressRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AddressServiceTest {
//
//	@InjectMocks
//	private AddressServiceImpl add_ser;
//	
//	@Mock
//	private AddressRepository add_repo;
//	
//	
//	@Test
//	public void addAddressTest() throws AddressNotFoundException{
//		
//		Address add = new Address();
//		
//		add.setBuildingName("prany_build");
//		add.setAddressId("1218");
//		add.setCity("Hyderabad");
//		add.setCountry("India");
//		add.setState("Telangana");
//		add.setPincode("504201");
//		
//		Mockito.doReturn(add).when(add_repo).save(Mockito.any());
//
//		assertEquals(add.getBuildingName(), add_ser.addAddress(add).getBuildingName());
//		
//	}
//	
//}
