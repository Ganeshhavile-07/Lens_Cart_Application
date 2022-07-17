package com.cg.ls.service;

import java.util.List;

import com.cg.ls.entity.Lenses;
import com.cg.ls.exception.LensesNotFoundException;
import com.cg.ls.exception.NoProperDataException;



public interface LensesService  {
    
	 //the lenses service class is consist of all business related method declaration

	public List<Lenses> getAllLenses() throws LensesNotFoundException;

	public Lenses addLenses(Lenses lenses) throws NoProperDataException;

	public Lenses updateLenses(Lenses lenses, Integer id) throws LensesNotFoundException;

	public String deleteLenses(Integer id) throws LensesNotFoundException;

	public Lenses getLensesById(Integer id) throws LensesNotFoundException;
}
