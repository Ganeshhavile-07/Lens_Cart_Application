package com.cg.lenscart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("customer_details")
public class Customer {
	public static final String SEQUENCE_NAME = null;
	@Id
	private int cust_id;
	private String username;
	private String email;
	private String age;
	private String contact_No;
}