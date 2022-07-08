package com.capg.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product,String>{

	Product findByproductId(String id);

	//Product findBycatId(String cname);

	Product deleteByproductId(String pid);
	
	@Query("select p from Product p where p.category=:c")
	 public List<Product> findAllProductByCategory(@Param("c") String cname);

}
