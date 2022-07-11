package com.capg.onlineshop.productexception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{
	
	public ProductNotFoundException(String s)
	{
		super(s);
	}

}
