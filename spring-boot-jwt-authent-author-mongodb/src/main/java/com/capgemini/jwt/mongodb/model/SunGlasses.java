package com.capgemini.jwt.mongodb.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	@NotBlank
	@Size(max = 100)
	private String glassname;
	
	@NotBlank
	@Size(max = 100)
	private FrameColor frameColor;
	
	@NotBlank
	@Size(max = 100)
	private GlassColor glassColor;
	
	@NotBlank
	@Size(max = 100)
	private GlassShape glassShape;
	
	@NotBlank
	@Size(max = 100)
	private String weight;
	
	@NotBlank
	@Size(max = 100)
	private double glassPrice;
	
	

}
