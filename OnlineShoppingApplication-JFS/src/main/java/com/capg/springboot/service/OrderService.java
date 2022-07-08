package com.capg.springboot.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.springboot.Exceptions.OrderNotFoundException;
import com.capg.springboot.dto.Orderdto;
import com.capg.springboot.entity.OrderTable;

public interface OrderService {

	public OrderTable addOrder(Orderdto orderdto);
	public OrderTable updateOrder(Orderdto orderdto);
	public OrderTable removeOrder(OrderTable order);
	public OrderTable viewOrder(OrderTable order);
	
	public List<OrderTable> viewAllOrders(LocalDate date) throws OrderNotFoundException;
	public List<OrderTable> findCustomerByCity(String location) throws OrderNotFoundException;
}
