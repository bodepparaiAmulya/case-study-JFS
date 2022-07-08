package com.capg.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.Exceptions.CartNotFoundException;
import com.capg.springboot.entity.Cart;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.entity.Product;
import com.capg.springboot.repository.CartRepository;
import com.capg.springboot.repository.CustomerRepository;
import com.capg.springboot.repository.ProductRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cart_repo;
    
    @Autowired
    private ProductRepository pro_repo;
    
    @Autowired
    private CustomerRepository cust_repo;
    
    /* Method: addProductToCart 
	 * Description: It adds product to the cart.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cart.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
	@Override
	public Cart addProductToCart(Cart cart, Product p, int quantity){
		p.setQuantity(quantity);
		
		pro_repo.save(p);
		cart_repo.save(cart);	
		List<Product> list=new ArrayList<>();
		list.add(p);
		cart.setProducts(list);			
		     	return cart;
		
	}
	
	/* Method: updateProductToCart 
	 * Description: It updates product to the cart.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cart.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		p.setQuantity(quantity);
		cart_repo.save(cart);
		pro_repo.save(p);
		List<Product> list=new ArrayList();
		list.add(p);
		cart.setProducts(list);
		return cart;
	}
	
	/* Method: viewAllProducts 
	 * Description: It view the products in the cart.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cart.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
	@Override
	public Cart viewAllProducts(Cart cart) {
		
		Product product=pro_repo.findByproductId(cart.getCartId());
		Customer customer=cust_repo.findByCustomerId(cart.getCartId());
		List<Product> list=new ArrayList();
		list.add(product);
		cart.setProducts(list);
		cart.setCustomer(customer);
		return cart;
	
	}
	
	/* Method: removeAllProducts 
	 * Description: It adds product to the cart.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cart.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */

	@Override
	public Cart removeAllProducts(Cart cart) {
		Cart cart1 = cart_repo.findByCartId(cart.getCartId());
		pro_repo.deleteAll(cart1.getProducts());
		List<Product> products = cart1.getProducts();
		products.clear();
		cart_repo.save(cart1);
		return cart1;
		
	}
	
	/* Method: removeProductFromCart 
	 * Description: It remove product to the cart.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cart.
     * Created By- Singireddy Pranay
     * Created Date -30-11-2021  
     */
	@Override
	public Cart removeProductFromCart(Cart cart, Product p) {
		Cart cart1 = cart_repo.findByCartId(cart.getCartId());
		List<Product> list = cart1.getProducts();
		for (Product product : list) {
			if(product.getProductId().equals(p.getProductId())) {
				pro_repo.delete(p);
				list.remove(p);
				break;
			}
		}
		cart_repo.save(cart1);
		return cart1;
		
	}

}
