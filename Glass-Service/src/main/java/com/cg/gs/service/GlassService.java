package com.cg.gs.service;

import java.util.List;
import com.cg.gs.entity.Glass;
import com.cg.gs.exception.GlassNotFoundException;
import com.cg.gs.exception.NoProperDataException;


public interface GlassService {

	// the glass service class is consist of all business related method declaration

	public List<Glass> getAllGlass() throws GlassNotFoundException;

	public Glass addGlass(Glass glass) throws NoProperDataException;

	public Glass updateGlass(Glass glass, Integer id) throws GlassNotFoundException;

	public String deleteGlass(Integer id) throws GlassNotFoundException;

	public Glass getGlassById(Integer id) throws GlassNotFoundException;
}