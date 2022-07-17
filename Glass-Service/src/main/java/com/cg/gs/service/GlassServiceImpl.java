package com.cg.gs.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gs.entity.Glass;
import com.cg.gs.exception.GlassNotFoundException;
import com.cg.gs.exception.NoProperDataException;
import com.cg.gs.repository.GlassRepository;

import lombok.extern.slf4j.Slf4j;

//@Service means the class consist of all business related logic
@Service
@Slf4j
public class GlassServiceImpl implements GlassService {
    
	@Autowired
	private GlassRepository glassRepository;

	@Override
	public List<Glass> getAllGlass() throws GlassNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all customers  from here");
		if(glassRepository.findAll().isEmpty())
		{
			throw new GlassNotFoundException("No Glass Found"); 
		}
		else
		{
		return glassRepository.findAll();
		}
	}

	@Override
	public Glass addGlass(Glass glass) throws NoProperDataException {
		// TODO Auto-generated method stub
		Glass glasses=glassRepository.save(glass);
		if(glasses==null) 
		{
			throw new NoProperDataException("Please fill fields");
		}
		return glasses;
	}

	@Override
	public Glass updateGlass(Glass glass, Integer id) throws GlassNotFoundException {
		// TODO Auto-generated method stub
		log.info("update");
		Glass glasses=glassRepository.findById(id).orElseThrow(()-> new  GlassNotFoundException("No glass Availble wth this id"));
		
		glasses.setGlassname(glass.getGlassname());
		glasses.setGlassColor(glass.getGlassColor());
		glasses.setGlass_price(glass.getGlass_price());
		glasses.setGlass_weight(glass.getGlass_weight());
		glasses.setGlassShape(glass.getGlassShape());
		
		final Glass updatedglass=glassRepository.save(glasses);
		return updatedglass;
	}

	@Override
	public String deleteGlass(Integer id) throws GlassNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
		var isRemoved = glassRepository.findById(id);
		if(isRemoved.isPresent())
		{
			glassRepository.deleteById(id);
			log.debug("deleted succesfully {}",isRemoved.get());
		}
		else
		{
			throw new GlassNotFoundException("glass not available to delete on given id");
		}
		log.info("end");
		return "deleted";
	}

	@Override
	public Glass getGlassById(Integer id) throws GlassNotFoundException {
		// TODO Auto-generated method stub
		Glass glass=glassRepository.findById(id).orElseThrow(()-> new GlassNotFoundException("Glass Not Found with id "+id));
		return glass;
				//ResponseEntity.ok().body(lo);
		//getById id takes only id has input (it will not take object Product product)
	
	}





}
