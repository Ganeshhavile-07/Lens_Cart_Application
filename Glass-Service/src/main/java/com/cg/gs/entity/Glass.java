package com.cg.gs.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "glass_details")
public class Glass {

	public Glass(int i, String string, String string2, String string3, int j) {

	}

	public static final String SEQUENCE_NAME = "glass_sequence";

	public enum GlassColor {
		BLACK, PURPLE, RED, BLUE, WHITE
	}

	public enum GlassShape {
		ROUND, OVAL, RECTANGLE, CATEYE
	}

	// glass info: id, name, shape, weight, price
	@Id
	Integer glassId;

	@NotBlank
	String glassname;
	GlassColor glassColor;
	GlassShape glassShape;
	String glassWeight;
	double glassPrice;
}
