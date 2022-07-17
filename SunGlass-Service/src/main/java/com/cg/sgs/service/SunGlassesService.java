package com.cg.sgs.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.sgs.entity.SunGlasses;
import com.cg.sgs.exception.NoProperDataException;
import com.cg.sgs.exception.SunGlassesNotFoundException;


public interface SunGlassesService {
     
	 //the sunglasses service class is consist of all business related method declaration
	public  ResponseEntity<List<SunGlasses>> getAllSunGlasses() throws  SunGlassesNotFoundException;
	public ResponseEntity<SunGlasses> getSunGlassesById(@PathVariable int id) throws SunGlassesNotFoundException;
	public ResponseEntity<SunGlasses> addSunGlasses(@RequestBody SunGlasses sunglasses)  throws NoProperDataException;
	public ResponseEntity<SunGlasses> updateSunGlasses(@RequestBody SunGlasses sunglasses ,@PathVariable int id)  throws SunGlassesNotFoundException;
	public ResponseEntity<String> deleteSunGlasses(@PathVariable Integer id) throws SunGlassesNotFoundException;

}
