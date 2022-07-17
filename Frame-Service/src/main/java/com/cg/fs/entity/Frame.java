package com.cg.fs.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "frame_details")
//getter setter method: by using this we can get and set the data
@Data
//Parameterized constructor: by using this initialized the values
@AllArgsConstructor
//No argument constructor: by using using address the class
@NoArgsConstructor
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
