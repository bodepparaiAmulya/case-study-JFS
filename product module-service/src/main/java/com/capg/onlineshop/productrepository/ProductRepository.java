package com.capg.onlineshop.productrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.capg.onlineshop.productmodel.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product,Long>{
}
