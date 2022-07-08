package com.capg.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.Exceptions.ProductNotFoundException;
import com.capg.springboot.dto.Productdto;
import com.capg.springboot.entity.Cart;
import com.capg.springboot.entity.Category;
import com.capg.springboot.entity.Product;
import com.capg.springboot.repository.CartRepository;
import com.capg.springboot.repository.CategoryRepository;
import com.capg.springboot.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
  
	@Autowired
	private ProductRepository pro_repo;
	@Autowired
	private CartRepository cart_repo;
	@Autowired 
	private CategoryRepository cat_repo;
	
	/* Method: viewAllProducts 
	 * Description: It view all the products.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the product.
     * Created By- Sourabh Chougule
     * Created Date -30-11-2021  
     */
	@Override
	public List<Product> viewAllProducts() {
	
		return pro_repo.findAll();
	}
	
	/* Method: viewProduct 
	 * Description: It view  the products with the particular id.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the product.
     * Created By- Sourabh Chougule
     * Created Date -30-11-2021  
     */
    
	@Override
	public Product viewProduct(String id) {
		
		return pro_repo.findByproductId(id);
	}
	
	/* Method: removeProduct 
	 * Description: It remove  the products with the particular id.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the product.
     * Created By- Sourabh Chougule
     * Created Date -30-11-2021  
     */

	@Override
	public Product removeProduct(String pid) throws ProductNotFoundException {
		Product product= pro_repo.deleteByproductId(pid);
		   if(product==null)
			   throw new ProductNotFoundException("Product Not Found Exception");
		   return product;
	}
	
	/* Method: addProduct 
	 * Description: It add the products.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the product.
     * Created By- Sourabh Chougule
     * Created Date -30-11-2021  
     */

	@Override
	public Product addProduct(Productdto productdto) {
		Cart cart = cart_repo.findByCartId(productdto.getCartId());
		Category category=cat_repo.findByCatId(productdto.getCatId());
		// copy each field from productdto to Product
		// sdd cart and category to Product.
		Product product = new Product();
		product.setCart(cart);
		product.setCategory(category);
		product.setColor(productdto.getColor());
		product.setDimension(productdto.getDimension());
		product.setManufacturer(productdto.getManufacturer());
		product.setPrice(productdto.getPrice());
		product.setProductId(productdto.getProductId());
		product.setProductName(productdto.getProductName());
		product.setQuantity(productdto.getQuantity());
		product.setSpecification(productdto.getSpecification());
		return pro_repo.save(product);
	}

	/* Method: updateProduct 
	 * Description: It update  the product.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the product.
     * Created By- Sourabh Chougule
     * Created Date -30-11-2021  
     */
	@Override
	public Product updateProduct(Productdto productdto) {
		// TODO Auto-generated method stub
		Cart cart = cart_repo.findByCartId(productdto.getCartId());
		Category category=cat_repo.findByCatId(productdto.getCatId());
		// copy each field from productdto to Product
		// sdd cart and category to Product.
		Product product = new Product();
		product.setCart(cart);
		product.setCategory(category);
		product.setColor(productdto.getColor());
		product.setDimension(productdto.getDimension());
		product.setManufacturer(productdto.getManufacturer());
		product.setPrice(productdto.getPrice());
		product.setProductId(productdto.getProductId());
		product.setProductName(productdto.getProductName());
		product.setQuantity(productdto.getQuantity());
		product.setSpecification(productdto.getSpecification());
		return pro_repo.save(product);
	
	}

	/* Method: findAllProductByCategoryProduct 
	 * Description: It view  the products with the particular category id.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the product.
     * Created By- Sourabh Chougule
     * Created Date -30-11-2021  
     */
	@Override
	public List<Product> findAllProductByCategory(String cname) throws ProductNotFoundException {
          
		List<Product> product= pro_repo.findAllProductByCategory(cname);
		 if(product==null||product.size()==0)
			 throw new ProductNotFoundException("Product Not Found");
		return product;
	}

	}
