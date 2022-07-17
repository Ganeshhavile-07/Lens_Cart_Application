package com.cg.sgs.controller;


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

import com.cg.sgs.entity.SunGlasses;
import com.cg.sgs.exception.NoProperDataException;
import com.cg.sgs.exception.SunGlassesNotFoundException;
import com.cg.sgs.service.SequenceGeneratorService;
import com.cg.sgs.service.SunGlassesServiceImpl;

import lombok.extern.slf4j.Slf4j;

//@Restcontroller means it is a combination of controller and RequestBody
//@Controller means it is handle the web request
//@RequestMapping means it is handle the map the web request
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class SunGlassesController {
     
	@Autowired
	private SunGlassesServiceImpl sunServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	//to get all information in browser
	@GetMapping("/allsunglasses") 
	public ResponseEntity<List<SunGlasses>> getAllSunGlasses() throws SunGlassesNotFoundException
	{
		log.info("starting  of get mapping");
		return sunServiceImpl.getAllSunGlasses();
		
	}
	
	//to get information in browser with the help of id
	@GetMapping("/sunglass/{id}")
	public ResponseEntity<SunGlasses> getSunGlassesById(@PathVariable  Integer id)
	throws SunGlassesNotFoundException{
		return sunServiceImpl.getSunGlassesById(id);
	}
	
	//save the information
	@PostMapping("/addsunglass") 
	public ResponseEntity<SunGlasses> addSunGlasses(@RequestBody SunGlasses glass)  throws NoProperDataException
	{
		log.info("start");
		glass.setSunGlassId(sequenceGeneratorService.getSequenceNumberForSunGlasses(SunGlasses.SEQUENCE_NAME));
		return sunServiceImpl.addSunGlasses(glass);
	}
	
	//update the information
	@PutMapping("/updatesunglass/{id}")
	public ResponseEntity<SunGlasses> updateSunGlasses(@RequestBody SunGlasses sunglass,@PathVariable int id) throws SunGlassesNotFoundException
	{
		return sunServiceImpl.updateSunGlasses(sunglass, id);
	}
	

	//delete the information
	@DeleteMapping(path="/deletesunglass/{id}")
	public ResponseEntity<String> deleteSunGlasses(@PathVariable int id) throws SunGlassesNotFoundException {
			return sunServiceImpl.deleteSunGlasses(id);
	}
}
