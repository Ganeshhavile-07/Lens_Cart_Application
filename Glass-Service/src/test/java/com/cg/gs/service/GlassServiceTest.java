package com.cg.gs.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.gs.entity.Glass;
import com.cg.gs.exception.GlassNotFoundException;
import com.cg.gs.exception.NoProperDataException;
import com.cg.gs.repository.GlassRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class GlassServiceTest {
	

	@InjectMocks
	private GlassServiceImpl glassServiceImpl;
	
	@Mock
	private GlassRepository glassRepository;
	
	@Test
	void testServiceNotNull() {
		assertThat(glassServiceImpl).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(glassRepository).isNotNull();
	}
	
	@Test
	void testGetAllGlasses() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
		Glass g2 = new Glass(200, "Rectangular Glass", "BLACK", "RECTANGLE", 1000);
		List<Glass> glasslist=new ArrayList<Glass>();
		glasslist.add(g1);
		glasslist.add(g2);
		when(glassRepository.findAll()).thenReturn(glasslist);
		assertEquals(glasslist,glassServiceImpl.getAllGlass());
		
	}
	
	@Test
	void testGetGlassById() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
		when(glassRepository.findById(101)).thenReturn(Optional.of(g1));
		assertEquals(g1,glassServiceImpl.getGlassById(101));
	}
	
	@Test
	void testGetGlassByInvalidId() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
		when(glassRepository.findById(2000)).thenReturn(Optional.of(g1));
		try {
			assertThat(glassServiceImpl.getGlassById(2001)).as("Customer with the id 1000 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAddGlassException() throws GlassNotFoundException {
		
		Glass p1= null;//new Planter(2000,9, "red","oval",10, 90);
//		when(planterRepository.findById(2000)).thenReturn(Optional.of(p1));
	try {
	glassServiceImpl.addGlass(p1);
	}catch(Exception e) {
		assertEquals("Please fill fields", e.getMessage());
	}
	}
	@Test
	void testAddGlass() throws GlassNotFoundException, NoProperDataException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
		when(glassRepository.findById(2000)).thenReturn(Optional.of(g1));
		((List<Glass>) assertThat(glassServiceImpl.addGlass(g1)))
		.contains("added successfully....");
	
	}	
	
	@Test
	void testAddGlassAlreadyExists() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
		when(glassRepository.findById(101)).thenReturn(Optional.of(g1));
	try {
		((List<Glass>) assertThat(glassServiceImpl.addGlass(g1)))
		.contains("Glass with the id "+g1.getGlassId()+" already exist");
	}catch(Exception e) {
		
	}
	}
//	
	@Test
	void testupdateGlass() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
		when(glassRepository.findById(2000)).thenReturn(Optional.of(g1));
		assertThat(glassServiceImpl.updateGlass(g1))
		.contains("updated successfully....");
	
	}
	
	@Test
	void testupdateGlassDoesnotExists() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);
		when(glassRepository.findById(10)).thenReturn(Optional.of(g1));
	try {
		assertThat(glassServiceImpl.updateGlass(g1))
		.contains("Glass with the id "+g1.getGlassId()+" doesn't exist for update");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testDeleteGlassById() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);

		when(glassRepository.findById(101)).thenReturn(Optional.of(g1));
		assertThat(glassServiceImpl.deleteGlass(101))
		.contains("deleted successfully....");
	}
	
	@Test
	void testDeleteGlassByInvalidId() throws GlassNotFoundException {
		Glass g1 = new Glass(100, "Circular Glass", "RED", "RECTANGLE", 1000);	
		when(glassRepository.findById(101)).thenReturn(Optional.of(g1));
		try {
			assertThat(glassServiceImpl.deleteGlass(2000))
			.contains("Planter with the id "+g1.getGlassId()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
	
	}