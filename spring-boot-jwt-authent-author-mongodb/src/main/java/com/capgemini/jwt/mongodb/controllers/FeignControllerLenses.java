package com.capgemini.jwt.mongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.LensesNotFoundException;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.model.Lenses;
import com.capgemini.jwt.mongodb.util.FeignClientUtilLenses;


@RestController
@RequestMapping("/api/v1")
public class FeignControllerLenses {
	@Autowired
    private FeignClientUtilLenses feignlenses;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/alllenses") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Lenses>> getAllLenses(@RequestHeader("Authorization")  String token) throws LensesNotFoundException
    {

        return feignlenses.getAllLenses(token);

    }

    @GetMapping("/lenses/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Lenses> getLensesById(@RequestHeader("Authorization")  String token, @PathVariable  Integer id)
    throws LensesNotFoundException{
        return feignlenses.getLensesById(token, id);
    }

    @PostMapping("/addlenses") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Lenses> addLenses(@RequestHeader("Authorization")  String token, @RequestBody Lenses lenses)  throws NoProperDataException
    {
        lenses.setLensId((int) service.getSequenceNumberForLenses(Lenses.SEQUENCE_NAME));

        return feignlenses.addLenses(token, lenses);
    }

//    @PutMapping("/updatelenses/{id}")
//    @PreAuthorize( "hasRole('ADMIN')")
//    public ResponseEntity<Lenses> updateLenses(@RequestBody Lenses lenses,@PathVariable Integer id) throws LensesNotFoundException
//    {
//    return feignlenses.updateLenses(lenses, id);
//    }
   
    @DeleteMapping(path="/deletelenses/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteLenses(@RequestHeader("Authorization")  String token, @PathVariable Integer id) throws LensesNotFoundException {
            return feignlenses.deleteLenses(token, id);
}

}
