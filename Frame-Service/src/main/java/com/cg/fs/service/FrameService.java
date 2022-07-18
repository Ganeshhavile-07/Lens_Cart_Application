package com.cg.fs.service;

import java.util.List;

import com.cg.fs.entity.Frame;
import com.cg.fs.exception.FrameNotFoundException;
import com.cg.fs.exception.NoProperDataException;



public interface FrameService {
      
	public List<Frame> getAllFrame() throws FrameNotFoundException;

	public Frame addFrame(Frame frame) throws NoProperDataException;

	public String updateFrame(Frame frame) throws FrameNotFoundException;

	public String deleteFrame(Integer id) throws FrameNotFoundException;

	public Frame getFrameById(Integer id) throws FrameNotFoundException;
}
