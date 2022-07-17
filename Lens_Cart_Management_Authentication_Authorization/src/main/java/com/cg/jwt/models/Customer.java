package com.cg.jwt.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer_details")
public class Customer {
	
	@Transient
	public static final String SEQUENCE_NAME = "customer_sequence";

	// customer_information: cust_id, UserName, email, age, contact_no
	@Id
	private long cust_id;
	private String username;
	private String email;
	private String age;
	private String contact_No;
}
