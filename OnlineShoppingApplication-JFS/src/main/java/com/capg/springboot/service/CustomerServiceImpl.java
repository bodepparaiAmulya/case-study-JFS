package com.capg.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.springboot.Exceptions.CustomerNotFoundException;
import com.capg.springboot.dto.Customerdto;
import com.capg.springboot.entity.Address;
import com.capg.springboot.entity.Cart;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.repository.AddressRepository;
import com.capg.springboot.repository.CartRepository;
import com.capg.springboot.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository cust_repo;
	@Autowired
	private AddressRepository add_repo;
	@Autowired
	private CartRepository cart_repo;
	
	/* Method: addCustomer 
	 * Description: It adds the customer.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the customer.
     * Created By- Soudagar Saif Ali
     * Created Date -30-11-2021  
     */
	@Override
	public Customer addCustomer(Customerdto custdto) {
		Address address=add_repo.findByAddressId(custdto.getAddressid());
		Cart cart=cart_repo.findByCartId(custdto.getCartId());
		Customer customer=new Customer();
		customer.setAddress(address);
		customer.setCart(cart);
		customer.setCustomerId(custdto.getCustomerId());
		customer.setEmail(custdto.getEmail());
		customer.setFirstName(custdto.getFirstName());
		customer.setLastName(custdto.getLastName());
		customer.setMobileNumber(custdto.getMobileNumber());
		return cust_repo.save(customer);
	}
	
	/* Method: removeCustomer 
	 * Description: It removes the customer.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the customer.
     * Created By- Soudagar Saif Ali
     * Created Date -30-11-2021  
     */

	@Override
	public Customer removeCustomer(Customer cust) {
		cust_repo.delete(cust);
        return cust;
	}
	
	/* Method: findCustomerId 
	 * Description: It find the customer by id.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the customer.
     * Created By- Soudagar Saif Ali
     * Created Date -30-11-2021  
     */
	@Override
	public Customer findByCustomerId(Customer cust) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
		 
	   Customer customer=cust_repo.findByCustomerId(cust.getCustomerId());
	          if(customer==null)
	        	  throw new CustomerNotFoundException("CustomerNOtFound");
	     return customer;     
	}
	
	/* Method: addCustomer 
	 * Description: It adds the customer.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the customer.
     * Created By- Soudagar Saif Ali
     * Created Date -30-11-2021  
     */
	@Override
	public List<Customer> findCustomerByCity(String location)throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		
		List<Customer> customer= cust_repo.findCustomerByCity(location);
		   if(customer==null)
			   throw new CustomerNotFoundException("Customer not Found");
		return customer;
	}
}
