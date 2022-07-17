package com.cg.gs.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//getter setter method: by using this we can get and set the data
@Data
//Parameterized constructor: by using this initialized the values
@AllArgsConstructor
//No argument constructor: by using using address the class
@NoArgsConstructor
@Document(collection = "glass_details")
public class Glass {

	public static final String SEQUENCE_NAME = "glass_sequence";

	public enum GlassColor {
		BLACK, PURPLE, RED, BLUE, WHITE
	}

	public enum GlassShape {
		ROUND, OVAL, RECTANGLE, CATEYE
	}

	// glass info: id, name, shape, weight, price
	@Id
	private int glass_id;
	private String glassname;

	private GlassColor glassColor;
	private GlassShape glassShape;
	private String glass_weight;
	private double glass_price;
}
