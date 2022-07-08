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
//import com.capg.springboot.dto.Orderdto;
//import com.capg.springboot.entity.OrderTable;
//import com.capg.springboot.repository.AddressRepository;
//import com.capg.springboot.repository.OrderRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OrderTableServiceTest {
//
//	@InjectMocks
//	private OrderServiceImpl order_ser;
//	
//	@Mock
//	private OrderRepository order_repo;
//	
//
//	@Test
//	public void addCartTest() {
//		/*
//		 * OrderTable order=new OrderTable(); order.setOrderId("1218");
//		 * 
//		 * Mockito.doReturn(order).when(order_repo).save(Mockito.any());
//		 * 
//		 * assertEquals(order.getOrderId(), order_ser.addOrder(Orderdto.class).);
//		 */
//		OrderTable order=new OrderTable(); 
//		order.setOrderId("1218");
//		Mockito.when(order_repo.save(order)).thenReturn(order);
//	}
//}
