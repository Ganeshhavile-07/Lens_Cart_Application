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
@Document(collection = "lenses_details")
public class Lenses {

	@Transient
	public static final String SEQUENCE_NAME = "lenses_sequence";

	public enum Type {
		SPHERICAL, FAR_VISION_SPHERICAL, MULTIFOCAL
	}

	public enum Disposability {
		MONTHLY, DAY_NIGHT, DAILY, YEARLY, BI_WEEKLY

	}

	// lenses info: id, type, price, colour, disposability
	@Id
	private int lensId;

	@NotBlank
	@Size(max = 100)
	private Type lensType;

	@NotBlank
	@Size(max = 100)
	private double lensprice;

	@NotBlank
	@Size(max = 100)
	private String lensColour;

	@NotBlank
	@Size(max = 100)
	private Disposability lensDisposability;
}
