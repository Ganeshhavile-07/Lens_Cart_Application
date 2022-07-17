package com.cg.ls.controller;

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

import com.cg.ls.entity.Lenses;
import com.cg.ls.exception.LensesNotFoundException;
import com.cg.ls.exception.NoProperDataException;
import com.cg.ls.service.LensesServiceImpl;
import com.cg.ls.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

//@Restcontroller means it is a combination of controller and RequestBody
//@Controller means it is handle the web request
//@RequestMapping means it is handle the map the web request
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class LensesController {

	@Autowired
	private LensesServiceImpl lensesServiceImpl;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/alllenses") // users/admin
	public ResponseEntity<List<Lenses>> getAllLenses() throws LensesNotFoundException {
		// productserviceimpl.getAllProducts();
		return new ResponseEntity<>(lensesServiceImpl.getAllLenses(), HttpStatus.OK);
	}

	// admin/users
	@GetMapping("/getlenses/{id}")
	public ResponseEntity<Lenses> getLensesById(@PathVariable Integer id) throws LensesNotFoundException {
		Lenses lenses = lensesServiceImpl.getLensesById(id);
		return ResponseEntity.ok().body(lenses);
	}

	@PostMapping("/addlenses") // only admin
	public ResponseEntity<Lenses> addLenses(@RequestBody Lenses lenses) throws NoProperDataException {
		lenses.setLensId(sequenceGeneratorService.getSequenceNumberForLenses(Lenses.SEQUENCE_NAME));
		// productserviceimpl.addProduct(product);
		return new ResponseEntity<>(lensesServiceImpl.addLenses(lenses), HttpStatus.CREATED);
	}

	@PutMapping("/updatelenses/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public ResponseEntity<Lenses> updateLenses(@RequestBody Lenses lenses, @PathVariable Integer id)
			throws LensesNotFoundException {
		;
		return ResponseEntity.ok(lensesServiceImpl.updateLenses(lenses, id));
	}

	@DeleteMapping("/deletelenses/{id}") // only delete
	public ResponseEntity<String> deleteLenses(@PathVariable Integer id) throws LensesNotFoundException {
		lensesServiceImpl.deleteLenses(id);
		return ResponseEntity.ok(id + " deleted successfully");
	}
}