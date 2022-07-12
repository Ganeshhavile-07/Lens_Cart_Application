package com.cg.lenscart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.lenscart.entity.Lenses;
import com.cg.lenscart.exception.LensesNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.repository.LensesRepository;
import com.cg.lenscart.service.LensesService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LensesServiceImpl implements LensesService {
    
	@Autowired
	private LensesRepository lensesRepository;
	
	@Override
	public ResponseEntity<List<Lenses>> getAllLenses() throws LensesNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all lenses from here");
		return new ResponseEntity<>(lensesRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Lenses> getLensesById(int id) throws LensesNotFoundException {
		// TODO Auto-generated method stub
		Lenses lenses = lensesRepository.findById(id)
				.orElseThrow(() -> new LensesNotFoundException("Lenses Not Found" + id));

		return ResponseEntity.ok().body(lenses);
	}

	@Override
	public ResponseEntity<Lenses> addLenses(Lenses lenses) throws NoProperDataException {
		// TODO Auto-generated method stub
		log.info("start");
		if (lenses != null) {
			lensesRepository.save(lenses);
			System.out.println("lenses added");
		} else {
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(lenses);
	}

	@Override
	public ResponseEntity<Lenses> updateLenses(Lenses lens, int id) throws LensesNotFoundException {
		// TODO Auto-generated method stub
		Lenses lenses = lensesRepository.findById(id)
				.orElseThrow(() -> new LensesNotFoundException("lenses not available for thid id: " + id));
        lenses.setLensType(lens.getLensType());
        lenses.setLensColour(lens.getLensColour());
        lenses.setLensprice(lens.getLensprice());
        lenses.setLensDisposability(lens.getLensDisposability());
		
	
		final Lenses updatedLenses = lensesRepository.save(lenses);
		return ResponseEntity.ok(updatedLenses);	
	}

	@Override
	public ResponseEntity<String> deleteLenses(Integer id) throws LensesNotFoundException {
		// TODO Auto-generated method stub
		log.info("Start delete");
		var isRemoved =lensesRepository.findById(id);
		if(isRemoved.isPresent())
		{
			lensesRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new LensesNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return ResponseEntity.ok(id+" deleted successfully");
	}

}
