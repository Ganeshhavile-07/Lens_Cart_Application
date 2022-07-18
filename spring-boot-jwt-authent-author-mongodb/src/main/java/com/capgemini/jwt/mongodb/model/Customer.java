package com.capgemini.jwt.mongodb.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	@NotBlank
	@Size(max = 100)
	private String username;
	
	@NotBlank
	@Size(max = 100)
	private String email;
	
	@NotBlank
	@Size(max = 100)
	private String age;
	
	@NotBlank
	@Size(max = 100)
	private String contact_No;
}
