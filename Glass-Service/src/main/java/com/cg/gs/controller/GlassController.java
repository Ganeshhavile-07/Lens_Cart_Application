package com.cg.gs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gs.entity.Glass;
import com.cg.gs.exception.GlassNotFoundException;
import com.cg.gs.exception.NoProperDataException;
import com.cg.gs.service.GlassServiceImpl;
import com.cg.gs.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class GlassController {

	@Autowired
	private GlassServiceImpl glassServiceImpl;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/allglasses") // users/admin
	public ResponseEntity<List<Glass>> getAllGlasses() throws GlassNotFoundException {
		List<Glass> glass=glassServiceImpl.getAllGlass();
		log.info("starting  of get mapping");
	
		if(glass.size()>0) {
			log.debug("glasses are {}"
					+ glass);
		 return new  ResponseEntity<>(glass,HttpStatus.OK); 
		}
		else {
			log.debug(" no glass found ");
			 return new  ResponseEntity<>(glass,HttpStatus.NO_CONTENT); 
		}
	}

	// admin/users
	@GetMapping("/glasses/{id}")
	public ResponseEntity<Glass> getGlassById(@Valid @PathVariable Integer id) throws GlassNotFoundException {
		Glass glass= glassServiceImpl.getGlassById(id);
		if(glass!=null){
		  return ResponseEntity.ok().body(glass);
		}
		  else {
			return new   ResponseEntity(glass,HttpStatus.NOT_FOUND);
		  }
	}

	@PostMapping("/addglass") // only admin
	public ResponseEntity<Glass> addGlass(@RequestBody Glass glass) throws NoProperDataException {
		if(glass!=null) 
		{
			glass.setGlassId(sequenceGeneratorService.getSequenceNumberForGlass(Glass.SEQUENCE_NAME));
			glassServiceImpl.addGlass(glass);
			log.error("added glass");
			return new ResponseEntity<>(glass,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
			
		}
	}

	@PutMapping("/updateglass/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public String updateGlass(@Valid @RequestBody Glass glass)
			throws GlassNotFoundException {
		String gla=glassServiceImpl.updateGlass(glass);
		return gla;
	}

	@DeleteMapping("/deleteglass/{id}") // only delete
	public ResponseEntity<String> deleteGlass(@PathVariable Integer id) throws GlassNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				glassServiceImpl.deleteGlass(id);
			} catch (GlassNotFoundException e) {
				throw new GlassNotFoundException("Glass with the id "+id+" doesn't exist");
				//log.error(e.getMessage());
			}
			}
			else
			{
				
				log.info("id not found");
			}
			
		}
		
		
			return ResponseEntity.ok(" deleted operation done ");
	}
}
