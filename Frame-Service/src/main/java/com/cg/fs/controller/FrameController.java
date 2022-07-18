package com.cg.fs.controller;

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

	@GetMapping("/allframes") // users/admin
	public ResponseEntity<List<Frame>> getAllFrames() throws FrameNotFoundException {
		List<Frame> frame=frameServiceImpl.getAllFrame();
		log.info("starting  of get mapping");
	
		if(frame.size()>0) {
			log.debug("frames are {}"
					+ frame);
		 return new  ResponseEntity<>(frame,HttpStatus.OK); 
		}
		else {
			log.debug(" no frame found ");
			 return new  ResponseEntity<>(frame,HttpStatus.NO_CONTENT); 
		}
	}

	// admin/users
	@GetMapping("/frames/{id}")
	public ResponseEntity<Frame> getFrameById(@Valid @PathVariable Integer id) throws FrameNotFoundException {
		Frame frame= frameServiceImpl.getFrameById(id);
		if(frame!=null){
		  return ResponseEntity.ok().body(frame);
		}
		  else {
			return new   ResponseEntity(frame,HttpStatus.NOT_FOUND);
		  }
	}

	@PostMapping("/addframe") // only admin
	public ResponseEntity<Frame> addFrame(@RequestBody Frame frame) throws NoProperDataException {
		if(frame!=null) 
		{
			frame.setFrameId(sequenceGeneratorService.getSequenceNumberForFrame(Frame.SEQUENCE_NAME));
			frameServiceImpl.addFrame(frame);
			log.error("added frame");
			return new ResponseEntity<>(frame,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
			
		}
	}

	@PutMapping("/updateframe/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public String updateFrame(@Valid @RequestBody Frame frame)
			throws FrameNotFoundException {
		String fra=frameServiceImpl.updateFrame(frame);
		return fra;
	}

	@DeleteMapping("/deleteframe/{id}") // only delete
	public ResponseEntity<String> deleteFrame(@PathVariable Integer id) throws FrameNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				frameServiceImpl.deleteFrame(id);
			} catch (FrameNotFoundException e) {
				throw new FrameNotFoundException("Frame with the id "+id+" doesn't exist");
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
