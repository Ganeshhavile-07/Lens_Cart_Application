package com.cg.gs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.gs.entity.Glass;

public class GlassTest {
   
	Glass g1;
	@BeforeEach
	public void before() {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
	}
	
	
	@AfterEach
	public void after() {
		g1=null;
	}
	
	@Test
	void testGetGlassId() {
		assertEquals(100, g1.getGlassId());
	}

	@Test
	void testGetGlassName() {
		assertEquals(9, g1.getGlassname());
	}

	@Test
	void testGetGlassColor() {
		assertEquals("RED", g1.getGlassColor());
	}
	
	@Test
     void testGetGlassShape() {
		assertEquals("RECTANGLE",g1.getGlassShape());
	}
	
	@Test
	void testGetGlassPrice() {
		assertEquals(100, g1.getGlassPrice());
	}

	
	
	
	@Test
	void testSetGlassId() {
		g1.setGlassId(200);
		assertEquals(101, g1.getGlassId());
	}
    
	@Test
	void testSetGlassName() {
		g1.setGlassname("Circular Glass");
		assertEquals("Circular Glass", g1.getGlassname());
	}
	
	
	@Test
	void testSetGlassPrice() {
		g1.setGlassPrice(1000);;
		assertEquals(1000, g1.getGlassPrice());
	}
	
	@Test
	void testSetGlassWeight() {
		g1.setGlassWeight("0.9gram");;
		assertEquals("0.9gram", g1.getGlassWeight());
	}
	
	
	
	
	
	


}
