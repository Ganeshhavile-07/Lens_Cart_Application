package com.cg.lenscart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "glass_details")
public class Glass {
   
	public static final String SEQUENCE_NAME = "glass_sequence";
	
	
	public enum GlassColor {BLACK,PURPLE,RED,BLUE,WHITE}
	public enum GlassShape {ROUND,OVAL,RECTANGLE,CATEYE}
	@Id
	private int glass_id;
	private String glassname;
	
	private GlassColor glassColor;
	private GlassShape glassShape;
	private String glass_weight;
	private double glass_price;
}
