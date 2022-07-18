package com.capgemini.jwt.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequence_lenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequenceLenses {

  	@Id
    private String  id;
    private long seq;
}
