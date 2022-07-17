package com.cg.jwt.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "db_sequence_frame")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequenceFrame {
	@Id
    private String  id;
    private long seq;
}
