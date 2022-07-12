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

import com.cg.lenscart.entity.SunGlasses;

import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.exception.SunGlassesNotFoundException;
import com.cg.lenscart.serviceimpl.SequenceGeneratorService;
import com.cg.lenscart.serviceimpl.SunGlassesServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class SunGlassesController {
     
	@Autowired
	private SunGlassesServiceImpl sunServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/allsunglasses") 
	public ResponseEntity<List<SunGlasses>> getAllSunGlasses() throws SunGlassesNotFoundException
	{
		log.info("starting  of get mapping");
		return sunServiceImpl.getAllSunGlasses();
		
	}
	
	@GetMapping("/sunglass/{id}")
	public ResponseEntity<SunGlasses> getSunGlassesById(@PathVariable  Integer id)
	throws SunGlassesNotFoundException{
		return sunServiceImpl.getSunGlassesById(id);
	}
	
	@PostMapping("/addsunglass") 
	public ResponseEntity<SunGlasses> addSunGlasses(@RequestBody SunGlasses glass)  throws NoProperDataException
	{
		log.info("start");
		glass.setSunGlassId(sequenceGeneratorService.getSequenceNumberForSunGlasses(SunGlasses.SEQUENCE_NAME));
		return sunServiceImpl.addSunGlasses(glass);
	}
	
	@PutMapping("/updatesunglass/{id}")
	public ResponseEntity<SunGlasses> updateSunGlasses(@RequestBody SunGlasses sunglass,@PathVariable int id) throws SunGlassesNotFoundException
	{
		return sunServiceImpl.updateSunGlasses(sunglass, id);
	}
	

	@DeleteMapping(path="/deletesunglass/{id}")
	public ResponseEntity<String> deleteSunGlasses(@PathVariable int id) throws SunGlassesNotFoundException {
			return sunServiceImpl.deleteSunGlasses(id);
	}
}
