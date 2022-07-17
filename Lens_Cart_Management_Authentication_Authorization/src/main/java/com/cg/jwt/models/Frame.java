package com.cg.jwt.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "frame_details")
public class Frame {
    
	public static final String SEQUENCE_NAME = "frame_sequence";
	@Id
	private int frameId;

	// name, color, price, description
	public enum Shape {
		RECTANGLE, OVAL, ROUND, CATEYE, WAYFARER, SQUARE, HEXAGONAL
	}

	public enum FrameColor {
		BLACK, PURPLE, RED, BLUE, WHITE
	}

	public enum Size {
		LARGE, MEDIUM, SMALL
	}

	//frame info: id, name, colour, shape, price , size, description
	private String frame_name;

	private String frameColour;

	private Shape frameShape;

	private Size frameSize;
	private double frameprice;
	private String description;
	
}
