package com.capgemini.jwt.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "db_sequence_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequenceCustomer {
   
 	@Id
    private String  id;
    private long seq;
}
