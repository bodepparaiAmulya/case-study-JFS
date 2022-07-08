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
//import com.capg.springboot.Exceptions.UserNotFoundException;
//import com.capg.springboot.entity.Address;
//import com.capg.springboot.entity.User;
//import com.capg.springboot.repository.UserRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserServiceTest {
//	@InjectMocks
//	private UserServiceImpl login_ser;
//	
//	@Mock
//	private UserRepository login_repo;
//	
//	@Test
//	public void addUserTest() throws UserNotFoundException{
//		
//		User user = new User();
//		user.setUserId("1218");
//		user.setPassword("Pass");
//		user.setRole("user");
//		
//		
//		Mockito.doReturn(user).when(login_repo).save(Mockito.any());
//
//		assertEquals(user.getUserId(), login_ser.addUser(user).getUserId());
//		
//	}
//	
//}
