package com.capg.onlineshop.product.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.onlineshop.product.exception.NoProperDataException;
import com.capg.onlineshop.product.exception.ProductNotFoundException;
import com.capg.onlineshop.product.exception.ProductsNotFoundException;
import com.capg.onlineshop.product.model.Product;
import com.capg.onlineshop.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepository productrepository;
	//@Override: It indicates that the child class method is over-writing its base class method.
	@Override  
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
	@Override   
	public ResponseEntity<Product> getProductById(@RequestBody Product product,@PathVariable Long id) throws ProductNotFoundException{
		log.info("get products by id starts from here");
		Product po=productrepository.findById(id).orElseThrow(()-> new ProductNotFoundException("User Not Found with id "+id));
		return ResponseEntity.ok().body(po);
	}
	
	@Override  
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
		Product bean=productrepository.save(product);
		if(bean==null) 
		{
			throw new NoProperDataException("Name can't be duplicate");
		}
		return new ResponseEntity<>(bean,HttpStatus.CREATED);
	}

	@Override 
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, Long id) throws ProductNotFoundException {
		log.info("update");
		Product pro=productrepository.findById(id).orElseThrow(()-> new  ProductNotFoundException("No Product Availble wth this id"));
		pro.setProductName(product.getProductName());
	    pro.setPrice(product.getPrice());
		pro.setColor((product.getColor()));
		pro.setQuantity(product.getQuantity());
		pro.setSpecification(product.getSpecification());
		final Product updatedProduct=productrepository.save(pro);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@Override 
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