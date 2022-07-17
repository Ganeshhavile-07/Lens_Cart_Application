package com.cg.jwt.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment_details")
public class Payment {
	public static final String SEQUENCE_NAME = "payment_sequence";
	public enum PaymentType {
		ONLINE, CASH,CHECK,UPI
	}
	private int paymentId;
	private PaymentType paymentType;
}
