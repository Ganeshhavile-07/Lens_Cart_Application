package com.cg.fs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fs.entity.Frame;
import com.cg.fs.exception.FrameNotFoundException;
import com.cg.fs.exception.NoProperDataException;
import com.cg.fs.repository.FrameRepository;


import lombok.extern.slf4j.Slf4j;

//@Service means the class consist of all business related logic
@Service
@Slf4j
public class FrameServiceImpl implements FrameService {

	@Autowired
	private FrameRepository frameRepository;

	@Override
	public List<Frame> getAllFrame() throws FrameNotFoundException {

		List<Frame> frames = frameRepository.findAll();
		log.debug("Frames are :{}", frames);

		return frames;
	}

	@Override
	public Frame addFrame(Frame frame) throws NoProperDataException {

		log.info("start");
		if (frame != null) {
			frameRepository.save(frame);
			log.debug("added frame");
		} else {
			throw new NoProperDataException("Please fill fields");
		}
		return frame;
	}

	@Override
	public String updateFrame(Frame frame) throws FrameNotFoundException {

		Optional<Frame> frames = frameRepository.findById(frame.getFrameId());
		Frame fra = null;
		if (!frames.isPresent()) {
			log.debug("frame not found");
			throw new FrameNotFoundException("Frame with the id " + frame.getFrameId() + " doesn't exist for update");

		} else {
			fra=frames.get();
			fra.setFrameId(frame.getFrameId());
			fra.setFrame_name(frame.getFrame_name());
			fra.setFrameColour(frame.getFrameColour());
			fra.setFrameprice(frame.getFrameprice());
			fra.setFrameShape(frame.getFrameShape());
			fra.setFrameSize(frame.getFrameSize());
			fra.setDescription(frame.getDescription());
			
			log.debug("updated successfully {}", fra);
		}

		return fra + "\n updated successfully....";
	}

	@Override
	public String deleteFrame(Integer id) throws FrameNotFoundException {

		log.info("start");
		Optional<Frame> frame = frameRepository.findById(id);

		if (!frame.isPresent()) {
			throw new FrameNotFoundException("Frame with the id " + id + " doesn't exist");
		} else {
			frameRepository.deleteById(id);
			log.debug(" frame deleted successfully {}", frame.get());
		}
		log.info("End");
		return id + " frame  deleted successfully....";
	}

	@Override
	public Frame getFrameById(Integer id) throws FrameNotFoundException {

		log.info("start");
		return frameRepository.findById(id)
				.orElseThrow(() -> new FrameNotFoundException("Frame with the id " + id + " doesn't exist"));
	}

}
