package com.cg.lenscart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lenscart.entity.Frame;
import com.cg.lenscart.exception.FrameNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.repository.FrameRepository;
import com.cg.lenscart.service.FrameService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FrameServiceImpl implements FrameService {

	@Autowired
	private FrameRepository frameRepository;

	@Override
	public ResponseEntity<List<Frame>> getAllFrames() throws FrameNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all frames from here");
		return new ResponseEntity<>(frameRepository.findAll(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Frame> getFramesById(int id) throws FrameNotFoundException {
		// TODO Auto-generated method stub
		Frame frames = frameRepository.findById(id)
				.orElseThrow(() -> new FrameNotFoundException("Frame Not Found" + id));

		return ResponseEntity.ok().body(frames);
	}

	@Override
	public ResponseEntity<Frame> addFrames(Frame frame) throws NoProperDataException {
		// TODO Auto-generated method stub
		log.info("start");
		if (frame != null) {
			frameRepository.save(frame);
			System.out.println("frame added");
		} else {
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(frame);
	}

	@Override
	public ResponseEntity<Frame> updateFrames(Frame frame, int id) throws FrameNotFoundException {
		// TODO Auto-generated method stub
		Frame frames = frameRepository.findById(id).orElseThrow(() -> new FrameNotFoundException("frame not " + id));

		frames.setFrame_name(frame.getFrame_name());
		frames.setFrameShape(frame.getFrameShape());
		frames.setFrameColour(frame.getFrameColour());
		frames.setFrameSize(frame.getFrameSize());
		frames.setFrameprice(frame.getFrameprice());
		frames.setDescription(frame.getDescription());

		final Frame updatedFrames = frameRepository.save(frames);
		return ResponseEntity.ok(updatedFrames);

	}
	
	
//	@Override
//	public ResponseEntity<Customer> deleteCustomer(Plant id) throws CustomerNotFoundException {
//		log.info("Start delete");
//		var isRemoved =customerRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			customerRepository.delete(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new CustomerNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return new ResponseEntity<>(id,HttpStatus.OK);
//	}


}