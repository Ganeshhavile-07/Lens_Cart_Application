package com.cg.gs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gs.entity.Glass;
import com.cg.gs.exception.GlassNotFoundException;
import com.cg.gs.exception.NoProperDataException;
import com.cg.gs.repository.GlassRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GlassServiceImpl implements GlassService {

	@Autowired
	private GlassRepository glassRepository;

	@Override
	public List<Glass> getAllGlass() throws GlassNotFoundException {

		List<Glass> glasses = glassRepository.findAll();
		log.debug("Glasses are :{}", glasses);

		return glasses;
	}

	@Override
	public Glass addGlass(Glass glass) throws NoProperDataException {

		log.info("start");
		if (glass != null) {
			glassRepository.save(glass);
			log.debug("added glass");
		} else {
			throw new NoProperDataException("Please fill fields");
		}
		return glass;
	}

	@Override
	public String updateGlass(Glass glass) throws GlassNotFoundException {

		Optional<Glass> glasses = glassRepository.findById(glass.getGlassId());
		Glass gla = null;
		if (!glasses.isPresent()) {
			log.debug("planter not found");
			throw new GlassNotFoundException("Glass with the id " + glass.getGlassId() + " doesn't exist for update");

		} else {
			gla = glasses.get();
			gla.setGlassId(glass.getGlassId());
			gla.setGlassname(glass.getGlassname());
			gla.setGlassColor(glass.getGlassColor());
			gla.setGlassPrice(glass.getGlassPrice());
			gla.setGlassWeight(glass.getGlassWeight());
			gla.setGlassShape(glass.getGlassShape());
			log.debug("updated successfully {}", gla);
		}

		return gla + "\n updated successfully....";
	}

	@Override
	public String deleteGlass(Integer id) throws GlassNotFoundException {

		log.info("start");
		Optional<Glass> glass = glassRepository.findById(id);

		if (!glass.isPresent()) {
			throw new GlassNotFoundException("Glass with the id " + id + " doesn't exist");
		} else {
			glassRepository.deleteById(id);
			log.debug(" glass deleted successfully {}", glass.get());
		}
		log.info("End");
		return id + " glass  deleted successfully....";
	}

	@Override
	public Glass getGlassById(Integer id) throws GlassNotFoundException {

		log.info("start");
		return glassRepository.findById(id)
				.orElseThrow(() -> new GlassNotFoundException("Glass with the id " + id + " doesn't exist"));
	}

}
