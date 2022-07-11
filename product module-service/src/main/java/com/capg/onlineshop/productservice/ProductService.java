package com.capg.onlineshop.productservice;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.capg.onlineshop.productexception.NoProperDataException;
import com.capg.onlineshop.productexception.ProductNotFoundException;
import com.capg.onlineshop.productexception.ProductsNotFoundException;
import com.capg.onlineshop.productmodel.Product;

public interface ProductService {
	
	public ResponseEntity<List<Product>> getAllProducts() throws  ProductsNotFoundException;
	public ResponseEntity<Product> getProductById(Product product,Long id) throws ProductNotFoundException;
	public ResponseEntity<Product> addProduct(Product product)  throws NoProperDataException;
	public ResponseEntity<Product> updateProduct(Product product ,Long id)  throws  ProductNotFoundException;
	public ResponseEntity<String> deleteProduct(Long id) throws  ProductNotFoundException;

}
