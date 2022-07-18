package com.capgemini.jwt.mongodb.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "frame_details")
public class Frame {

	@Transient
	public static final String SEQUENCE_NAME = "frame_sequence";
	
	

	// name, color, price, description
	public enum Shape {
		RECTANGLE, OVAL, ROUND, CATEYE, WAYFARER, SQUARE, HEXAGONAL
	}

	public enum FrameColor {
		BLACK, PURPLE, RED, BLUE, WHITE
	}

	public enum Sizes {
		LARGE, MEDIUM, SMALL
	}

	// frame info: id, name, colour, shape, price , size, description
	@Id
	private int frameId;
	
	@NotBlank
	@Size(max = 100)
	private String frame_name;

	@NotBlank
	@Size(max = 100)
	private String frameColour;

	@NotBlank
	@Size(max = 100)
	private Shape frameShape;

	@NotBlank
	@Size(max = 100)
	private Sizes frameSize;

	@NotBlank
	@Size(max = 100)
	private double frameprice;

	@NotBlank
	@Size(max = 50)
	private String description;

}
