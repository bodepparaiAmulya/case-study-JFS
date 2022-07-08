	package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.Exceptions.CustomerNotFoundException;
import com.capg.springboot.dto.Customerdto;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.service.CustomerService;



@RequestMapping("/customerController")
@CrossOrigin("http://localhost:4100")
@RestController
public class CustomerController {
  
	@Autowired
	private CustomerService cust_ser;
	/* Method: addCustomer
	 * Description: It allows to add the user.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     
     */
	@PostMapping("/addCust")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customerdto customer){
		Customer custImpl=cust_ser.addCustomer(customer);
		return new ResponseEntity(custImpl,HttpStatus.OK);
	}
	/* Method: viewAllCustomers
	 * Description: It allows to add the user.
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URI Expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     
     */
	@GetMapping("/viewCust/{location}")
	public ResponseEntity<List<Customer>> ViewAllCustomers(@PathVariable String location) throws CustomerNotFoundException{
		List<Customer> custImpl=cust_ser.findCustomerByCity(location);
		return new ResponseEntity(custImpl,HttpStatus.OK);
		}
	/* Method: findByCustomerId
	 * Description: It allows to find the customer by id.
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URI Expression.
 
     */
	@GetMapping("/viewCust") 
	public ResponseEntity<Customer> findByCustomerId(@RequestBody Customer customer)throws CustomerNotFoundException
	{ 
	Customer custImpl=cust_ser.findByCustomerId(customer);
	return new  ResponseEntity(custImpl,HttpStatus.OK);
	}
	
	/* Method: removeCustomer
	 * Description: It allows to remove the customer.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
     
     */
	@DeleteMapping("/removeCust") 
	public ResponseEntity<Customer> removeCustomer(@RequestBody Customer customer){
       Customer custImpl=cust_ser.removeCustomer(customer);
       return new ResponseEntity(custImpl,HttpStatus.OK); 
       }
	
}





