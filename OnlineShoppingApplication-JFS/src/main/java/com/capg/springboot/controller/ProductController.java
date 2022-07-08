package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.Exceptions.ProductNotFoundException;
import com.capg.springboot.dto.Productdto;
import com.capg.springboot.entity.Product;
import com.capg.springboot.service.ProductService;

@RestController
@RequestMapping("/productController")
public class ProductController {
	@Autowired
	private ProductService prod_ser;
	
	/* Method: addProduct
	 * Description: It allows to add the product.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
   
     */
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Productdto product){
		Product productimpl=prod_ser.addProduct(product);
		return new ResponseEntity(productimpl,HttpStatus.OK);
	}
	/* Method: viewAllProducts
	 * Description: It allows to view the products.	
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URI Expression	
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
   
     */
	
	@GetMapping("/viewAllProducts")
	public ResponseEntity<Product> viewAllProducts(){
		List<Product> productImpl=prod_ser.viewAllProducts();
		return new ResponseEntity(productImpl,HttpStatus.OK);
	}
	/* Method: updateProduct
	 * Description: It allows to update the product.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.	
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
   
     */
	
	@PostMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Productdto product){
		prod_ser.updateProduct(product);
		return new ResponseEntity(product,HttpStatus.OK);
	}
	/* Method: deleteProduct
	 * Description: It allows to remove the product .
     * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
   
     */
	
	@DeleteMapping("/removeProduct/{pid}")
	public ResponseEntity<Product> removeProduct(@PathVariable String pid) throws ProductNotFoundException{
		Product product=prod_ser.removeProduct(pid);
		return new ResponseEntity(product,HttpStatus.OK);
	}
	/* Method: findAllProductByCategory
	 * Description: It allows to find the product by category .
     * @GetMapping:It is used to handle the HTTP GET requests matched with given URI Expression	
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
    
     */
	@GetMapping("viewProduct/{cname}")
	public ResponseEntity<List<Product>>  findAllProductByCategory(@PathVariable String cname) throws ProductNotFoundException {
		List<Product> product=prod_ser.findAllProductByCategory(cname);
		return new ResponseEntity(product,HttpStatus.OK);
	}
}
