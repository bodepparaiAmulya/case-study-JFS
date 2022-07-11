package com.capg.onlineshop.productmodel;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="product")
public class Product {

	 @Transient
	 public static final String SEQUENCE_NAME = "product_sequence";
	 
	 //Pattern p=new Pattern();
	private long id;
	
	//@
	private String productname;
	
	//@NotBlank
	private String productdesc;
	
	//@NotBlank
	private double price;
	
	//@NotBlank
	private String  photo_path;
	

}
