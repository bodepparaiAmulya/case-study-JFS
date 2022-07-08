package com.capg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.dto.Orderdto;
import com.capg.springboot.entity.Address;
import com.capg.springboot.entity.OrderTable;
import com.capg.springboot.service.OrderService;

@RestController
@RequestMapping("/orderController")
public class OrderController {

	@Autowired
	private OrderService ord_ser;
	/* Method: addOrder
	 * Description: It allows to add the order.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     
     */
	@PostMapping("/addOrder")
	public ResponseEntity<OrderTable> addOrder(@RequestBody Orderdto orderdto){
      OrderTable order=ord_ser.addOrder(orderdto);
      return new ResponseEntity(order,HttpStatus.OK);
      
	}
	/* Method: updateOrder
	 * Description: It allows to update the order.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
   
     */

	@PostMapping("/updateOrder")
	public ResponseEntity<OrderTable> updateOrder(@RequestBody Orderdto orderdto){
		return null;
	}
	
	/* Method: deleteOrder
	 * Description: It allows to delete the order.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
   
     */
	
	@DeleteMapping("/removeOrder")
	public ResponseEntity<OrderTable> removeOrder(@RequestBody OrderTable ordertable){
		ord_ser.removeOrder(ordertable);
		return new ResponseEntity(ordertable,HttpStatus.OK);

}
	
}
