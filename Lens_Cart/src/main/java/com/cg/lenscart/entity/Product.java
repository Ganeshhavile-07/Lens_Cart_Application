package com.cg.lenscart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product_details")
public class Product {

	public static final String SEQUENCE_NAME = "product_sequence";
@Id
	private long productId;

	private String productType;

	private String productBrand;

	private String productName;

	private double productPrice;

	private String productDescription;

	private int productQuantity;
	
	
}
