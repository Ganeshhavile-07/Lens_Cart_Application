package com.cg.sgs.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.sgs.entity.SunGlasses;
import com.cg.sgs.exception.NoProperDataException;
import com.cg.sgs.exception.SunGlassesNotFoundException;
import com.cg.sgs.repository.SunGlassesRepository;

import lombok.extern.slf4j.Slf4j;

//@Service means the class consist of all business related logic
@Service
@Slf4j
public class SunGlassesServiceImpl implements SunGlassesService {

	@Autowired
	private SunGlassesRepository sunRepository;
	
	@Override
	public ResponseEntity<List<SunGlasses>> getAllSunGlasses() throws SunGlassesNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all sunglasses from here");
		return new ResponseEntity<>(sunRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SunGlasses> getSunGlassesById(int id) throws SunGlassesNotFoundException {
		// TODO Auto-generated method stub
		SunGlasses glasses = sunRepository.findById(id)
				.orElseThrow(() -> new SunGlassesNotFoundException("Sunglasses Not Found for this id: " + id));

		return ResponseEntity.ok().body(glasses);
	}

	@Override
	public ResponseEntity<SunGlasses> addSunGlasses(SunGlasses sunglasses) throws NoProperDataException {
		// TODO Auto-generated method stub
		log.info("start");
		if(sunglasses!=null) 
		{
			sunRepository.save(sunglasses);
			System.out.println("sunglasses added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(sunglasses);
	}

	@Override
	public ResponseEntity<SunGlasses> updateSunGlasses(SunGlasses sunglass, int id)
			throws SunGlassesNotFoundException {
		// TODO Auto-generated method stub
SunGlasses sunglasses=sunRepository.findById(id).orElseThrow(()-> new SunGlassesNotFoundException("sunglasses not available for this id: "+id));
		
		sunglasses.setGlassname(sunglass.getGlassname());
		sunglasses.setGlassColor(sunglass.getGlassColor());
		sunglasses.setFrameColor(sunglass.getFrameColor());
		sunglasses.setGlassPrice(sunglass.getGlassPrice());
		sunglasses.setGlassShape(sunglass.getGlassShape());
		sunglasses.setWeight(sunglass.getWeight());
		
		
		final SunGlasses updatedSunglasses = sunRepository.save(sunglasses);
		return ResponseEntity.ok(updatedSunglasses);
	}

	@Override
	public ResponseEntity<String> deleteSunGlasses(Integer id) throws SunGlassesNotFoundException {
		// TODO Auto-generated method stub
		log.info("Start delete");
		var isRemoved =sunRepository.findById(id);
		if(isRemoved.isPresent())
		{
			sunRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new SunGlassesNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return ResponseEntity.ok("sunglasses "+id+" deleted successfully");
	}

	

}
