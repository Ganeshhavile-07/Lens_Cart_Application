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
@Document(collection = "glass_details")
public class Glass {
	
	@Transient
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

	@NotBlank
	@Size(max = 100)
	private String glassname;

	@NotBlank
	@Size(max = 100)
	private GlassColor glassColor;

	@NotBlank
	@Size(max = 100)
	private GlassShape glassShape;

	@NotBlank
	@Size(max = 100)
	private String glass_weight;

	@NotBlank
	@Size(max = 100)
	private double glass_price;
}
