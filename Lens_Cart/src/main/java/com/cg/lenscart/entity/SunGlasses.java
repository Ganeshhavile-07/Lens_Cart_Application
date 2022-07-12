package com.cg.lenscart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
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
