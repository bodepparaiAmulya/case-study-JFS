package com.capg.springboot.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.springboot.Exceptions.OrderNotFoundException;
import com.capg.springboot.dto.Orderdto;
import com.capg.springboot.entity.Address;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.entity.OrderTable;
import com.capg.springboot.repository.AddressRepository;
import com.capg.springboot.repository.CustomerRepository;
import com.capg.springboot.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderRepository order_repo;
	@Autowired
	private AddressRepository add_repo;
	@Autowired
	private CustomerRepository cust_repo;
	
	
	/* Method: addOrder 
	 * Description: It adds the order.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the order.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
	@Override
	public OrderTable addOrder(Orderdto orderdto) {
		Address address=add_repo.findByAddressId(orderdto.getAddressId());
		Customer cust=cust_repo.findByCustomerId(orderdto.getCustomerId());
		OrderTable order=new OrderTable();
		order.setAddress(address);
		order.setCustomer(cust);
		order.setOrderId(orderdto.getOrderId());
		order.setOrderDate(orderdto.getOrderDate());
		order.setOrderStatus(orderdto.getOrderStatus());
		return order_repo.save(order);
			}
	
	/* Method: updateOrder 
	 * Description: It updates the order.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the order.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
	@Override
	public OrderTable updateOrder(Orderdto orderdto) {
		Address address=add_repo.findByAddressId(orderdto.getAddressId());
		Customer cust=cust_repo.findByCustomerId(orderdto.getCustomerId());
		OrderTable order=new OrderTable();
		order.setAddress(address);
		order.setCustomer(cust);
		order.setOrderId(orderdto.getOrderId());
		order.setOrderDate(orderdto.getOrderDate());
		order.setOrderStatus(orderdto.getOrderStatus());
		return order_repo.save(order);
	}
	
	/* Method: removeOrder 
	 * Description: It remove the order.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the order.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */

	@Override
	public OrderTable removeOrder(OrderTable order) {
	       order_repo.delete(order);
	       return order;
	}
	
	/* Method: viewOrder 
	 * Description: It adds the order.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the order.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
	@Override
	public OrderTable viewOrder(OrderTable order) {
		// TODO Auto-generated method stub
		order_repo.findAll();
		return null;
	}
	
	/* Method: viewAllOrder 
	 * Description: It view the order with respective date.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the order.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */

	@Override
	public List<OrderTable> viewAllOrders(LocalDate date) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		List<OrderTable> order=order_repo.findOrderByDate(date);
		    if(order==null)
		    	throw new OrderNotFoundException("Order not found");
		return order;
	}
	
	/* Method: findCustomerByCity 
	 * Description: It finds the order by particular city.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the order.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
    @Override
	public List<OrderTable> findCustomerByCity(String location) throws OrderNotFoundException {
		// TODO Auto-generated method stub
	      List<OrderTable> order=order_repo.findOrderByCity(location);
	            if(order==null)
	                 throw new  OrderNotFoundException("Order not found");
	      return order;
		
	}

}
