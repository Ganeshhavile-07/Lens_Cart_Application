package com.cg.lenscart.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "frame_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Frame {
   
	public static final String SEQUENCE_NAME = null;
	private int frameId;

	//name, color, price, description
	public enum Shape {
		RECTANGLE, OVAL, ROUND, CATEYE, WAYFARER, SQUARE, HEXAGONAL
	}

	public enum Size {
		LARGE, MEDIUM, SMALL
	}
	
	    private String frame_name;
	
	private String frameColour;

	
	private Shape frameShape;
	
	
	private Size frameSize;
	private double frameprice;
	private String description;
	
}
