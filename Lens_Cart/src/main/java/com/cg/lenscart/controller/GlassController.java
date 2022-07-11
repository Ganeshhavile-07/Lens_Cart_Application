package com.cg.lenscart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lenscart.entity.Glass;

import com.cg.lenscart.exception.GlassNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;

import com.cg.lenscart.serviceimpl.GlassServiceImpl;
import com.cg.lenscart.serviceimpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class GlassController {
     
	@Autowired
	private GlassServiceImpl glassServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/allglasses") 
	public ResponseEntity<List<Glass>> getAllGlasses() throws GlassNotFoundException
	{
		log.info("starting  of get mapping");
		return glassServiceImpl.getAllGlasses();
		
	}
	
	@GetMapping("/glass/{id}")
	public ResponseEntity<Glass> getGlassById(@PathVariable  Integer id)
	throws GlassNotFoundException{
		return glassServiceImpl.getGlassById(id);
	}
	
	@PostMapping("/addglass") 
	public ResponseEntity<Glass> addGlass(@RequestBody Glass glass)  throws NoProperDataException
	{
		log.info("start");
		glass.setGlass_id(sequenceGeneratorService.getSequenceNumberForGlass(Glass.SEQUENCE_NAME));
		return glassServiceImpl.addGlass(glass);
	}
	
	@PutMapping("/updateglass/{id}")
	public ResponseEntity<Glass> updateGlass(@RequestBody Glass glass,@PathVariable int id) throws GlassNotFoundException
	{
		return glassServiceImpl.updateGlass(glass, id);
	}
	

	@DeleteMapping(path="/deleteglass/{id}")
	public ResponseEntity<String> deleteGlasses(@PathVariable int id) throws GlassNotFoundException {
			return glassServiceImpl.deleteGlass(id);
	}
}
