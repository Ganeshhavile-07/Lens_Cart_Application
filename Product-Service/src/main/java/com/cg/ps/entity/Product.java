package com.cg.ps.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//getter setter method: by using this we can get and set the data
@Data
//Parameterized constructor: by using this initialized the values
@AllArgsConstructor
//No argument constructor: by using using address the class
@NoArgsConstructor
@Document(collection = "product_details")
public class Product {

	public static final String SEQUENCE_NAME = "product_sequence";
	
	//product info: id, type, brand, name, price, description
	@Id
	private long productId;

	private String productType;

	private String productBrand;

	private String productName;

	private double productPrice;

	private String productDescription;

	private int productQuantity;

}
