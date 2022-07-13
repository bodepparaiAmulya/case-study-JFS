package com.capg.onlineshop.product.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.capg.onlineshop.product.exception.NoProperDataException;
import com.capg.onlineshop.product.exception.ProductNotFoundException;
import com.capg.onlineshop.product.exception.ProductsNotFoundException;
import com.capg.onlineshop.product.model.Product;

public interface ProductService {
	
	public ResponseEntity<List<Product>> getAllProducts() throws  ProductsNotFoundException;
	public ResponseEntity<Product> getProductById(Product product,Long id) throws ProductNotFoundException;
	public ResponseEntity<Product> addProduct(Product product)  throws NoProperDataException;
	public ResponseEntity<Product> updateProduct(Product product ,Long id)  throws  ProductNotFoundException;
	public ResponseEntity<String> deleteProduct(Long id) throws  ProductNotFoundException;

}
