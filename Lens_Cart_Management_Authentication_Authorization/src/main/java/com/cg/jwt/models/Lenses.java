package com.cg.jwt.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lenses_details")
public class Lenses {

	public static final String SEQUENCE_NAME = "lenses_sequence";

	public enum Type {
		SPHERICAL, FAR_VISION_SPHERICAL, MULTIFOCAL
	}

	public enum Disposability {
		MONTHLY, DAY_NIGHT, DAILY, YEARLY, BI_WEEKLY

	}
    //lenses info: id, type, price, colour, disposability
	@Id
	private int lensId;
	private Type lensType;
	private double lensprice;
	private String lensColour;
	private Disposability lensDisposability;
}
