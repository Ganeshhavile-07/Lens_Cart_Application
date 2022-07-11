package com.cg.lenscart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.cg.lenscart.entity.Glass;
import com.cg.lenscart.exception.GlassNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;

public interface GlassService {
    
	public  ResponseEntity<List<Glass>> getAllGlasses() throws  GlassNotFoundException;
	public ResponseEntity<Glass> getGlassById(@PathVariable int id) throws GlassNotFoundException;
	public ResponseEntity<Glass> addGlass(@RequestBody Glass frames)  throws NoProperDataException;
	public ResponseEntity<Glass> updateGlass(@RequestBody Glass frame ,@PathVariable int id)  throws GlassNotFoundException;
	public ResponseEntity<String> deleteGlass(@PathVariable Integer id) throws GlassNotFoundException;

}
