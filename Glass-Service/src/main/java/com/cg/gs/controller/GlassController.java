package com.cg.gs.controller;

import java.util.List;

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

//@Restcontroller means it is a combination of controller and RequestBody
//@Controller means it is handle the web request
//@RequestMapping means it is handle the map the web request
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
		// productserviceimpl.getAllProducts();
		return new ResponseEntity<>(glassServiceImpl.getAllGlass(), HttpStatus.OK);
	}

	// admin/users
	@GetMapping("/getglass/{id}")
	public ResponseEntity<Glass> getGlassById(@PathVariable Integer id) throws GlassNotFoundException {
		Glass glass = glassServiceImpl.getGlassById(id);
		return ResponseEntity.ok().body(glass);
	}

	@PostMapping("/addglass") // only admin
	public ResponseEntity<Glass> addGlass(@RequestBody Glass glass) throws NoProperDataException {
		glass.setGlass_id(sequenceGeneratorService.getSequenceNumberForGlass(Glass.SEQUENCE_NAME));
		// productserviceimpl.addProduct(product);
		return new ResponseEntity<>(glassServiceImpl.addGlass(glass), HttpStatus.CREATED);
	}

	@PutMapping("/updateglass/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public ResponseEntity<Glass> updateGlass(@RequestBody Glass glass, @PathVariable Integer id)
			throws GlassNotFoundException {
		return ResponseEntity.ok(glassServiceImpl.updateGlass(glass, id));
	}

	@DeleteMapping("/deleteglass/{id}") // only delete
	public ResponseEntity<String> deleteGlass(@PathVariable Integer id) throws GlassNotFoundException {
		glassServiceImpl.deleteGlass(id);
		return ResponseEntity.ok(id + " deleted successfully");
	}
}
