package com.capg.onlineshop.productservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.onlineshop.productexception.NoProperDataException;
import com.capg.onlineshop.productexception.ProductNotFoundException;
import com.capg.onlineshop.productexception.ProductsNotFoundException;
import com.capg.onlineshop.productmodel.Product;
import com.capg.onlineshop.productrepository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepository productrepository;
	
	@Override   //=>user/Admin
	public ResponseEntity<List<Product>> getAllProducts() throws ProductsNotFoundException {
		log.info("get all products  from here");
		if(productrepository.findAll().isEmpty())
		{
			throw new ProductsNotFoundException("No Products Found"); 
		}
		else
		{
		return new  ResponseEntity<>(productrepository.findAll(),HttpStatus.OK);
		}
	}
	@Override   //only Admin
	public ResponseEntity<Product> getProductById(@RequestBody Product product,@PathVariable Long id) throws ProductNotFoundException{
		log.info("get products by id starts from here");
		Product po=productrepository.findById(id).orElseThrow(()-> new ProductNotFoundException("User Not Found with id "+id));
		return ResponseEntity.ok().body(po);
	}
	/*
	 * @Override
	public ResponseEntity<Login> getUsersById(@RequestBody Login login, Long id) throws UserNotFoundException {
		Login lo=loginrepo.findById(id).orElseThrow(()-> new UserNotFoundException("User Not Found with id "+id));
		return ResponseEntity.ok().body(lo);
	}
	 */

	@Override  //only Admin  //make modification on duplicate values
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
		Product bean=productrepository.save(product);
		if(bean==null) 
		{
			throw new NoProperDataException("Name can't be duplicate");
		}
		return new ResponseEntity<>(bean,HttpStatus.CREATED);
	}

	@Override //admin only 
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, Long id) throws ProductNotFoundException {
		log.info("update");
		Product pro=productrepository.findById(id).orElseThrow(()-> new  ProductNotFoundException("No Product Availble wth this id"));
		pro.setProductname(product.getProductname());
		pro.setProductdesc(product.getProductdesc());
		pro.setPrice(product.getPrice());
		pro.setPhoto_path(product.getPhoto_path());
		final Product updatedProduct=productrepository.save(pro);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@Override //only Admin
	public ResponseEntity<String> deleteProduct(@PathVariable Long  id) throws ProductNotFoundException {
		log.info("delete By Id");
		var isRemoved = productrepository.findById(id);
		if(isRemoved.isPresent())
		{
			productrepository.deleteById(id);
			log.debug("deleted succesfully {}",isRemoved.get());
		}
		else
		{
			throw new ProductNotFoundException("Product not available to delete");
		}
		log.info("end");
		return ResponseEntity.ok(id+" deleted successfully");
	}
}