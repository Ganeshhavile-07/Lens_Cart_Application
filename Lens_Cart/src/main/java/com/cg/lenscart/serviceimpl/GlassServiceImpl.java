package com.cg.lenscart.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.lenscart.entity.Glass;

import com.cg.lenscart.exception.GlassNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.repository.GlassRepository;
import com.cg.lenscart.service.GlassService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GlassServiceImpl implements GlassService {
    
	@Autowired
	private GlassRepository glassRepository;

	@Override
	public ResponseEntity<List<Glass>> getAllGlasses() throws GlassNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all glasses from here");
		return new ResponseEntity<>(glassRepository.findAll(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Glass> getGlassById(int id) throws GlassNotFoundException {
		// TODO Auto-generated method stub
		Glass glasses = glassRepository.findById(id)
				.orElseThrow(() -> new GlassNotFoundException("Glass Not Found" + id));

		return ResponseEntity.ok().body(glasses);
	}

	@Override
	public ResponseEntity<Glass> addGlass(Glass glasses) throws NoProperDataException {
		// TODO Auto-generated method stub
		log.info("start");
		if (glasses != null) {
			glassRepository.save(glasses);
			System.out.println("glass added");
		} else {
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(glasses);
	}

	@Override
	public ResponseEntity<Glass> updateGlass(Glass glass, int id) throws GlassNotFoundException {
		// TODO Auto-generated method stub
		Glass glasses = glassRepository.findById(id)
				.orElseThrow(() -> new GlassNotFoundException("glass not available for thid id: " + id));
        
		glasses.setGlassname(glass.getGlassname());
		glasses.setGlassColor(glass.getGlassColor());
		glasses.setGlass_price(glass.getGlass_price());
		glasses.setGlassShape(glass.getGlassShape());
		glasses.setGlass_weight(glass.getGlass_weight());
		
		final Glass updatedGlass = glassRepository.save(glasses);
		return ResponseEntity.ok(updatedGlass);	}

	@Override
	public ResponseEntity<String> deleteGlass(Integer id) throws GlassNotFoundException {
		// TODO Auto-generated method stub
		log.info("Start delete");
		var isRemoved =glassRepository.findById(id);
		if(isRemoved.isPresent())
		{
			glassRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new GlassNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return ResponseEntity.ok(id+" deleted successfully");
	}

	





}
