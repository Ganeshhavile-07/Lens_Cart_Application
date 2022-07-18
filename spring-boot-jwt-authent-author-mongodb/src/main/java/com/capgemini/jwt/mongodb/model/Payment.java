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
@Document(collection = "payment_details")
public class Payment {
	
	@Transient
	public static final String SEQUENCE_NAME = "payment_sequence";

	public enum PaymentType {
		ONLINE, CASH, CHECK, UPI
	}

	@Id
	private int paymentId;

	@NotBlank
	@Size(max = 100)
	private PaymentType paymentType;
}
