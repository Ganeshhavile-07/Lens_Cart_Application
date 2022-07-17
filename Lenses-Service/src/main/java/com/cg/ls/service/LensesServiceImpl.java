package com.cg.ls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ls.entity.Lenses;
import com.cg.ls.exception.LensesNotFoundException;
import com.cg.ls.exception.NoProperDataException;
import com.cg.ls.repository.LensesRepository;

import lombok.extern.slf4j.Slf4j;

//@Service means the class consist of all business related logic
@Service
@Slf4j
public class LensesServiceImpl implements LensesService {

	@Autowired
	private LensesRepository lensesRepository;

	@Override
	public List<Lenses> getAllLenses() throws LensesNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all customers  from here");
		if (lensesRepository.findAll().isEmpty()) {
			throw new LensesNotFoundException("No Lenses Found");
		} else {
			return lensesRepository.findAll();
		}
	}

	@Override
	public Lenses addLenses(Lenses lenses) throws NoProperDataException {
		// TODO Auto-generated method stub
		Lenses lensess = lensesRepository.save(lenses);
		if (lensess == null) {
			throw new NoProperDataException("Please fill fields");
		}
		return lensess;
	}

	@Override
	public Lenses updateLenses(Lenses lenses, Integer id) throws LensesNotFoundException {
		// TODO Auto-generated method stub
		log.info("update");
		Lenses lensess = lensesRepository.findById(id)
				.orElseThrow(() -> new LensesNotFoundException("No lens Availble wth this id"));
		lensess.setLensId(lenses.getLensId());
        lensess.setLensType(lenses.getLensType());
        lensess.setLensColour(lenses.getLensColour());
        lensess.setLensprice(lenses.getLensprice());
        lensess.setLensDisposability(lenses.getLensDisposability());
        
		final Lenses updatedlenses = lensesRepository.save(lensess);
		return updatedlenses;
	}

	@Override
	public String deleteLenses(Integer id) throws LensesNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
		var isRemoved = lensesRepository.findById(id);
		if (isRemoved.isPresent()) {
			lensesRepository.deleteById(id);
			log.debug("deleted succesfully {}", isRemoved.get());
		} else {
			throw new LensesNotFoundException("lens not available to delete on given id");
		}
		log.info("end");
		return "deleted";
	}

	@Override
	public Lenses getLensesById(Integer id) throws LensesNotFoundException {
		// TODO Auto-generated method stub
		Lenses lenses = lensesRepository.findById(id)
				.orElseThrow(() -> new LensesNotFoundException("Lenses Not Found with id " + id));
		return lenses;
		// ResponseEntity.ok().body(lo);
		// getById id takes only id has input (it will not take object Product product)
	}

}
