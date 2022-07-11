package com.cg.lenscart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.cg.lenscart.entity.Frame;
import com.cg.lenscart.exception.FrameNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;

public interface FrameService {
      
	public  ResponseEntity<List<Frame>> getAllFrames() throws  FrameNotFoundException;
	public ResponseEntity<Frame> getFrameById(@PathVariable int id) throws FrameNotFoundException;
	public ResponseEntity<Frame> addFrame(@RequestBody Frame frames)  throws NoProperDataException;
	public ResponseEntity<Frame> updateFrames(@RequestBody Frame frame ,@PathVariable int id)  throws FrameNotFoundException;
	public ResponseEntity<String> deleteFrames(@PathVariable Integer id) throws FrameNotFoundException;
}
