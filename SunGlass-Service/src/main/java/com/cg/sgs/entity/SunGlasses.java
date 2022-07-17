package com.cg.sgs.entity;

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
@Document(collection = "sunglasses_details")
public class SunGlasses {
       
	public static final String SEQUENCE_NAME = "sunglasses_sequence";
	public enum FrameColor {BLACK,PURPLE,RED,BLUE,WHITE}
	public enum GlassColor {BLACK,PURPLE,RED,BLUE,WHITE}
	public enum GlassShape {ROUND,OVAL,RECTANGLE,CATEYE}
	
	@Id
	private int sunGlassId;
	private String glassname;
	private FrameColor frameColor;
	private GlassColor glassColor;
	private GlassShape glassShape;
	private String weight;
	private double glassPrice;
	
	

}
