package com.capg.onlineshop.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshop.product.exception.NoProperDataException;
import com.capg.onlineshop.product.exception.ProductNotFoundException;
import com.capg.onlineshop.product.exception.ProductsNotFoundException;
import com.capg.onlineshop.product.model.Product;
import com.capg.onlineshop.product.service.ProductServiceImpl;
import com.capg.onlineshop.product.service.SequenceGeneratorService;

//Method: addProduct


@RestController
@RequestMapping("/productController")
public class ProductController {
	

	//here also handle negative flow for every method
	//@RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 // @RestController: It is used to create RESTful web services using MVC.
	 // @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 //@Autowired: It enables to inject object dependency implicitly.
	 // @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
	@Autowired
	private ProductServiceImpl productserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;

	
	@GetMapping("/viewAllProducts")  
	public ResponseEntity<List<Product>> getAllProducts() throws ProductsNotFoundException {
		return productserviceimpl.getAllProducts();
	}
	//Method: viewAllProducts
	 // Description: It allows to view the products.	
	 //@GetMapping:It is used to handle the HTTP GET requests matched with given URI Expression	
	 // @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
	@GetMapping("/get/{id}")   
	public ResponseEntity<Product> getProductById(@RequestBody Product product,@PathVariable  Long id) throws ProductNotFoundException {
		return productserviceimpl.getProductById(product, id);
	}
//Description: It allows to add the product.
	
	@PostMapping("/addproduct")  
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
		product.setId(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
		return productserviceimpl.addProduct(product);
	}

	@PutMapping("/updateproduct")  
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, Long id) throws ProductNotFoundException {
		return productserviceimpl.updateProduct(product, id);
	}
	//Method: deleteProduct
	 // Description: It allows to remove the product .
    // @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 // @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
	@DeleteMapping("removeProduct/{id}")  
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
		return productserviceimpl.deleteProduct(id);
	}
}
