package com.capg.onlineshop.productcontroller;

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

import com.capg.onlineshop.productexception.NoProperDataException;
import com.capg.onlineshop.productexception.ProductNotFoundException;
import com.capg.onlineshop.productexception.ProductsNotFoundException;
import com.capg.onlineshop.productmodel.Product;
import com.capg.onlineshop.productservice.ProductServiceImpl;
import com.capg.onlineshop.productservice.SequenceGeneratorService;




/**compulsory @PATHVariable and @REQUESTBODY is required for getbyId and deleteById
 **
 *
 
 *
 */
@RestController
@RequestMapping("/product-service")
public class ProductController {
	

	//here also handle negative flow for every method
	
	@Autowired
	private ProductServiceImpl productserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;

	
	@GetMapping("/allproducts")  //users/admin
	public ResponseEntity<List<Product>> getAllProducts() throws ProductsNotFoundException {
		return productserviceimpl.getAllProducts();
	}

	@GetMapping("/get/{id}")  //admin/users 
	public ResponseEntity<Product> getProductById(@RequestBody Product product,@PathVariable  Long id) throws ProductNotFoundException {
		return productserviceimpl.getProductById(product, id);
	}

	@PostMapping("/addproduct")  //only admin
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
		product.setId(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
		return productserviceimpl.addProduct(product);
	}

	@PutMapping("/updateproduct")  //admin only
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, Long id) throws ProductNotFoundException {
		return productserviceimpl.updateProduct(product, id);
	}

	@DeleteMapping("deleteproduct/{id}")  //only delete
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
		return productserviceimpl.deleteProduct(id);
	}
}
