package com.capgemini.jwt.mongodb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.CartNotFoundException;
import com.capgemini.jwt.mongodb.exception.RecordAlreadyExistsException;
import com.capgemini.jwt.mongodb.model.Cart;
import com.capgemini.jwt.mongodb.util.FeignClientUtilCart;



@RestController
@RequestMapping("/cartController")
public class FeignControllerCart {
	
	@Autowired
	private FeignClientUtilCart feignclientutilcart;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/cartdata")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws CartNotFoundException {//changed here on 12/07/22 ->11:27pm
		return feignclientutilcart.showAllDataInCarts();
	}

	 //only user
	@PostMapping("/addProductToCart") 
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Cart> addCart(@Valid @RequestBody Cart cart) throws RecordAlreadyExistsException {
		cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
		return feignclientutilcart.addCart(cart);
	}

  
	@PutMapping("/updateProductTocart")
	public ResponseEntity<Cart> updateCart(@Valid @RequestBody Cart cart ) throws CartNotFoundException {
		return feignclientutilcart.updateCart(cart );
	}

	  
	@DeleteMapping("/cancelProductincart/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Cart> cancelCart(@Valid @PathVariable Long id) throws CartNotFoundException {
		return feignclientutilcart.cancelCart(id); 
	}
}
