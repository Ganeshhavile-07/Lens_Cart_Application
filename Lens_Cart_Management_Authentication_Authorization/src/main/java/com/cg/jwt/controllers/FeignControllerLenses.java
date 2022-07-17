package com.cg.jwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.jwt.exception.FrameNotFoundException;
import com.cg.jwt.exception.LensesNotFoundException;
import com.cg.jwt.exception.NoProperDataException;
import com.cg.jwt.models.Lenses;
import com.cg.jwt.security.services.SequenceGeneratorService;
import com.cg.jwt.util.FeignClientUtilLenses;

public class FeignControllerLenses {
	@Autowired
    private FeignClientUtilLenses feignlenses;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/alllenses") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Lenses>> getAllLenses() throws LensesNotFoundException
    {

        return feignlenses.getAllLenses();

    }

    @GetMapping("/lenses/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Lenses> getLensesById(@PathVariable  Integer id)
    throws FrameNotFoundException{
        return feignlenses.getLensesById(id);
    }

    @PostMapping("/addlenses") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Lenses> addLenses(@RequestBody Lenses lenses)  throws NoProperDataException
    {
        lenses.setLensId((int) service.getSequenceNumberForLenses(Lenses.SEQUENCE_NAME));

        return feignlenses.addLenses(lenses);
    }

    @PutMapping("/updatelenses/{id}")
    @PreAuthorize( "hasRole('ADMIN')")
    public ResponseEntity<Lenses> updateLenses(@RequestBody Lenses lenses,@PathVariable Integer id) throws LensesNotFoundException
    {
    return feignlenses.updateLenses(lenses, id);
    }
   
    @DeleteMapping(path="/deletelenses/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteLenses(@PathVariable Integer id) throws LensesNotFoundException {
            return feignlenses.deleteLenses(id);
}

}
