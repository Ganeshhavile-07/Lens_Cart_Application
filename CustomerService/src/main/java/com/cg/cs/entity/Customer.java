package com.cg.cs.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

	@Transient
	public static final String SEQUENCE_NAME = "customer_sequence";

	// customer_information: cust_id, UserName, email, age, contact_no
	@Id
	private long custid;

	@NotBlank
	private String username;

	@NotBlank
	private String email;

	@NotBlank
	private int age;

	@NotBlank
	private String contactNo;
}
