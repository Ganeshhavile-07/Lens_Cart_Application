package com.cg.fs.service;

import java.util.List;

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
	public List<Frame> getAllFrames() throws FrameNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all customers  from here");
		if (frameRepository.findAll().isEmpty()) {
			throw new FrameNotFoundException("No Frame Found");
		} else {
			return frameRepository.findAll();
		}
	}

	@Override
	public Frame addFrame(Frame frame) throws NoProperDataException {
		// TODO Auto-generated method stub
		Frame frames = frameRepository.save(frame);
		if (frames == null) {
			throw new NoProperDataException("Please fill fields");
		}
		return frames;
	}

	@Override
	public Frame updateFrame(Frame frame, Integer id) throws FrameNotFoundException {
		// TODO Auto-generated method stub
		log.info("update");
		Frame frames = frameRepository.findById(id)
				.orElseThrow(() -> new FrameNotFoundException("No customer Availble wth this id"));
		frames.setFrame_name(frame.getFrame_name());
		frames.setFrameColour(frame.getFrameColour());
		frames.setFrameShape(frame.getFrameShape());
		frames.setFrameSize(frame.getFrameSize());
		frames.setFrameprice(frame.getFrameprice());
		frames.setDescription(frame.getDescription());

		final Frame updatedframe = frameRepository.save(frames);
		return updatedframe;
		// ResponseEntity.ok(updatedProduct);
	}

	@Override
	public String deleteFrame(Integer id) throws FrameNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
		var isRemoved = frameRepository.findById(id);
		if (isRemoved.isPresent()) {
			frameRepository.deleteById(id);
			log.debug("deleted succesfully {}", isRemoved.get());
		} else {
			throw new FrameNotFoundException("frame not available to delete on given id");
		}
		log.info("end");
		return "deleted";
	}

	@Override
	public Frame getFrameById(Integer id) throws FrameNotFoundException {
		// TODO Auto-generated method stub
		Frame frame = frameRepository.findById(id)
				.orElseThrow(() -> new FrameNotFoundException("Frame Not Found with id " + id));
		return frame;
		// ResponseEntity.ok().body(lo);
		// getById id takes only id has input (it will not take object Product product)

	}

}
