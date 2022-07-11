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


import com.cg.lenscart.entity.Frame;
import com.cg.lenscart.exception.FrameNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;

import com.cg.lenscart.serviceimpl.FrameServiceImpl;
import com.cg.lenscart.serviceimpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class FrameController {

	@Autowired
	private FrameServiceImpl frameServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/allframes") 
	public ResponseEntity<List<Frame>> getAllFrames() throws FrameNotFoundException
	{
		log.info("starting  of get mapping");
		return frameServiceImpl.getAllFrames();
		
	}
	
	@GetMapping("/frame/{id}")
	public ResponseEntity<Frame> getFrameById(@PathVariable  Integer id)
	throws FrameNotFoundException{
		return frameServiceImpl.getFrameById(id);
	}
	
	@PostMapping("/addframe") 
	public ResponseEntity<Frame> addFrame(@RequestBody Frame frame)  throws NoProperDataException
	{
		log.info("start");
		frame.setFrameId(sequenceGeneratorService.getSequenceNumberForFrame(Frame.SEQUENCE_NAME));
		return frameServiceImpl.addFrame(frame);
	}
	
	@PutMapping("/updateframe/{id}")
	public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame,@PathVariable int id) throws FrameNotFoundException
	{
		return frameServiceImpl.updateFrames(frame, id);
	}
	

	@DeleteMapping(path="/deleteframe/{id}")
	public ResponseEntity<String> deleteFrames(@PathVariable int id) throws FrameNotFoundException {
			return frameServiceImpl.deleteFrames(id);
	}
}
