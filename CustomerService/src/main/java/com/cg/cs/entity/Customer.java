package com.cg.cs.entity;

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
@Document(collection = "customer_details")
public class Customer {
	public static final String SEQUENCE_NAME = "customer_sequence";

	// customer_information: cust_id, UserName, email, age, contact_no
	@Id
	private Long cust_id;
	private String username;
	private String email;
	private String age;
	private String contact_No;
}
