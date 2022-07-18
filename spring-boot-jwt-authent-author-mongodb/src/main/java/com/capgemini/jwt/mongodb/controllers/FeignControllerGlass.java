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
import com.capgemini.jwt.mongodb.exception.GlassNotFoundException;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.model.Glass;
import com.capgemini.jwt.mongodb.util.FeignClientUtilGlass;


@RestController
@RequestMapping("/api/v1")
public class FeignControllerGlass {
	@Autowired
    private FeignClientUtilGlass feignglass;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/allglasses") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Glass>> getAllglasses(@RequestHeader String token) throws GlassNotFoundException
    {

        return feignglass.getAllGlasses(token);

    }

    @GetMapping("/glass/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Glass> getGlassById(@RequestHeader("Authorization")  String token, @PathVariable  Integer id)
    throws GlassNotFoundException{
        return feignglass.getGlassesById(token, id);
    }

    @PostMapping("/addglasses") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Glass> addGlass(@RequestHeader("Authorization")  String token, @RequestBody Glass glass)  throws NoProperDataException
    {
        glass.setGlass_id((int) service.getSequenceNumberForGlass(Glass.SEQUENCE_NAME));

        return feignglass.addGlasses(token, glass);
    }

//    @PutMapping("/updateglass/{id}")
//    @PreAuthorize( "hasRole('ADMIN')")
//    public ResponseEntity<Glass> updateGlass(@RequestBody Glass glass,@PathVariable Integer id) throws GlassNotFoundException
//    {
//    return feignglass.updateGlasses(glass, id);
//    }
   
    @DeleteMapping(path="/deleteglass/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteGlass(@RequestHeader("Authorization")  String token, @PathVariable Integer id) throws GlassNotFoundException {
            return feignglass.deleteGlasses(token, id);
}
}