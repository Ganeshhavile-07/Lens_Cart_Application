package com.cg.fs.controller;

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

import com.cg.fs.entity.Frame;
import com.cg.fs.exception.FrameNotFoundException;
import com.cg.fs.exception.NoProperDataException;
import com.cg.fs.service.FrameServiceImpl;
import com.cg.fs.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

//@Restcontroller means it is a combination of controller and RequestBody
//@Controller means it is handle the web request
//@RequestMapping means it is handle the map the web request
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class FrameController {

	@Autowired
	private FrameServiceImpl frameServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/allframes")  //users/admin
	public ResponseEntity<List<Frame>> getAllFrames() throws FrameNotFoundException {
		//productserviceimpl.getAllProducts();
		return new  ResponseEntity<>(frameServiceImpl.getAllFrames(),HttpStatus.OK);
	}

	
	 //admin/users 
	  @GetMapping("/getframe/{id}") 
	  public ResponseEntity<Frame> getFrameById(@PathVariable Integer id) throws FrameNotFoundException {
		  Frame frame= frameServiceImpl.getFrameById(id);
		  return ResponseEntity.ok().body(frame);
	  }
	 

	@PostMapping("/addframe")  //only admin
	public ResponseEntity<Frame> addFrame(@RequestBody Frame frame) throws NoProperDataException {
		frame.setFrameId(sequenceGeneratorService.getSequenceNumberForFrame(Frame.SEQUENCE_NAME));
		 //productserviceimpl.addProduct(product);
		 return new ResponseEntity<>(frameServiceImpl.addFrame(frame),HttpStatus.CREATED);
	}

	@PutMapping("/updateframe/{id}")  //admin only @PutMapping("/updateproduct/{id}") 
	public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame,@PathVariable Integer id) throws FrameNotFoundException {
		;
		 return ResponseEntity.ok(frameServiceImpl.updateFrame(frame,id));
	}

	@DeleteMapping("/deleteframe/{id}")  //only delete
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws FrameNotFoundException {
		frameServiceImpl.deleteFrame(id);
		 return ResponseEntity.ok(id+" deleted successfully");
	}	
}
