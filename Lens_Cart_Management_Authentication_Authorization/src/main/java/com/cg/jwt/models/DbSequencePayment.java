package com.cg.jwt.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequence_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequencePayment {
	@Id
    private String  id;
    private long seq;
}
