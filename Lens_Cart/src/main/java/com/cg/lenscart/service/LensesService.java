package com.cg.lenscart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.cg.lenscart.entity.Lenses;

import com.cg.lenscart.exception.LensesNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;

public interface LensesService  {
    
	public  ResponseEntity<List<Lenses>> getAllLenses() throws  LensesNotFoundException;
	public ResponseEntity<Lenses> getLensesById(@PathVariable int id) throws LensesNotFoundException;
	public ResponseEntity<Lenses> addLenses(@RequestBody Lenses lenses)  throws NoProperDataException;
	public ResponseEntity<Lenses> updateLenses(@RequestBody Lenses lenses ,@PathVariable int id)  throws LensesNotFoundException;
	public ResponseEntity<String> deleteLenses(@PathVariable Integer id) throws LensesNotFoundException;

}
