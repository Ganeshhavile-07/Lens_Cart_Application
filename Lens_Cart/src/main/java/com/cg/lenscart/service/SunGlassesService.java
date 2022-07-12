package com.cg.lenscart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.lenscart.entity.Lenses;
import com.cg.lenscart.entity.SunGlasses;
import com.cg.lenscart.exception.LensesNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.exception.SunGlassesNotFoundException;

public interface SunGlassesService {
     
	public  ResponseEntity<List<SunGlasses>> getAllSunGlasses() throws  SunGlassesNotFoundException;
	public ResponseEntity<SunGlasses> getSunGlassesById(@PathVariable int id) throws SunGlassesNotFoundException;
	public ResponseEntity<SunGlasses> addSunGlasses(@RequestBody SunGlasses sunglasses)  throws NoProperDataException;
	public ResponseEntity<SunGlasses> updateSunGlasses(@RequestBody SunGlasses sunglasses ,@PathVariable int id)  throws SunGlassesNotFoundException;
	public ResponseEntity<String> deleteSunGlasses(@PathVariable Integer id) throws SunGlassesNotFoundException;

}
