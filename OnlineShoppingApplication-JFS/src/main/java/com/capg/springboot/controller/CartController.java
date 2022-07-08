package com.capg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.dto.Cart_Productdto;
import com.capg.springboot.entity.Cart;
import com.capg.springboot.entity.Product;
import com.capg.springboot.service.CartService;

@RestController
@RequestMapping("/cartController")
public class CartController {

	@Autowired
	private CartService cart_ser;
	/* Method: addProductToCart
	 * Description: It allows to add the product to cart.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
    
     */
	@PostMapping("/addProductToCart/{quantity}")
	public ResponseEntity<Cart> addProductToCart(@RequestBody Cart_Productdto cart_productdto,@PathVariable int quantity  ){
		Cart cart=new Cart();
		cart.setCartId(cart_productdto.getCartdto().getCartId());
		Product product=new Product();
		product.setProductId(cart_productdto.getProductdto().getProductId());
		product.setProductName(cart_productdto.getProductdto().getProductName());
		cart_ser.addProductToCart(cart, product, quantity);
		return new ResponseEntity(cart,HttpStatus.OK);
	}
	/* Method:updateProductQuantity
	 * Description: It allows to update the product to cart.
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @PathVariable: It is used to handle template variables in the request URI
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
   
     */
	@PutMapping("/updateProductQuantity/{quantity}")
	public ResponseEntity<Cart> updateProductQuantity(@RequestBody Cart_Productdto cart_productdto,@PathVariable int quantity ){
		Cart cart=new Cart();
		cart.setCartId(cart_productdto.getCartdto().getCartId());
		Product product=new Product();
		product.setProductId(cart_productdto.getProductdto().getProductId());
		product.setProductName(cart_productdto.getProductdto().getProductName());
		cart_ser.addProductToCart(cart, product, quantity);
		return new ResponseEntity(cart,HttpStatus.OK);
	}
	/* Method: viewAllProducts
	 * Description: It allows to view the product.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     
     */
	@PostMapping("/viewAllProducts")
	public ResponseEntity<Cart> viewAllProducts(@RequestBody Cart cart){
		cart_ser.viewAllProducts(cart);
		return new ResponseEntity(cart,HttpStatus.OK);
	}
	/* Method: removeAllProducts
	 * Description: It allows to remove all the  products from cart.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
  
     */
	@PostMapping("/removeAllProducts")
	public ResponseEntity<Cart> removeAllProducts(@RequestBody Cart cart){
	   cart_ser.removeAllProducts(cart);
	   return new ResponseEntity(cart,HttpStatus.OK);
	}
	/* Method: removeProductFromCart
	 * Description: It allows to remove  the product from cart.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
    
     */
	@PostMapping("/removeProductFromCart")
	public ResponseEntity<Cart> removeProductFromCart(@RequestBody Cart cart,Product p){
		cart_ser.removeProductFromCart(cart,p);
		return new ResponseEntity(cart,HttpStatus.OK);
	}
	
	
}
