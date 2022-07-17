package com.cg.fs.service;

import java.util.List;

import com.cg.fs.entity.Frame;
import com.cg.fs.exception.FrameNotFoundException;
import com.cg.fs.exception.NoProperDataException;


public interface FrameService {
      
	 //the frame service class is consist of all business related method declaration
	
		public List<Frame> getAllFrames() throws  FrameNotFoundException;
		public Frame addFrame(Frame frame)  throws NoProperDataException;
		
		public Frame updateFrame(Frame frame, Integer id) throws FrameNotFoundException;
		public String deleteFrame(Integer id) throws FrameNotFoundException;
		public Frame getFrameById(Integer id) throws FrameNotFoundException;

}
