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


import com.cg.lenscart.entity.Lenses;

import com.cg.lenscart.exception.LensesNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.serviceimpl.LensesServiceImpl;
import com.cg.lenscart.serviceimpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class LensesController {
     
	@Autowired
	private LensesServiceImpl lensesServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/alllenses") 
	public ResponseEntity<List<Lenses>> getAllLenses() throws LensesNotFoundException
	{
		log.info("starting  of get mapping");
		return lensesServiceImpl.getAllLenses();
		
	}
	
	@GetMapping("/lenses/{id}")
	public ResponseEntity<Lenses> getLensesById(@PathVariable  Integer id)
	throws LensesNotFoundException{
		return lensesServiceImpl.getLensesById(id);
	}
	
	@PostMapping("/addlenses") 
	public ResponseEntity<Lenses> addLenses(@RequestBody Lenses lenses)  throws NoProperDataException
	{
		log.info("start");
		lenses.setLensId(sequenceGeneratorService.getSequenceNumberForLenses(Lenses.SEQUENCE_NAME));
		return lensesServiceImpl.addLenses(lenses);
	}
	
	@PutMapping("/updatelenses/{id}")
	public ResponseEntity<Lenses> updateLenses(@RequestBody Lenses lenses,@PathVariable int id) throws LensesNotFoundException
	{
		return lensesServiceImpl.updateLenses(lenses, id);
	}
	

	@DeleteMapping(path="/deletelenses/{id}")
	public ResponseEntity<String> deleteLenses(@PathVariable int id) throws LensesNotFoundException {
			return lensesServiceImpl.deleteLenses(id);
	}
}
