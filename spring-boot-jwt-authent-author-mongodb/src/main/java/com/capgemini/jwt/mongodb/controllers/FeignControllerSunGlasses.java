package com.capgemini.jwt.mongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.FrameNotFoundException;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.exception.SunGlassesNotFoundException;
import com.capgemini.jwt.mongodb.model.Frame;
import com.capgemini.jwt.mongodb.model.SunGlasses;
import com.capgemini.jwt.mongodb.util.FeignClientUtilSunGlasses;
import com.capgemini.jwt.mongodb.util.FiegnClientUtilFrame;

public class FeignControllerSunGlasses {
	@Autowired
    private FeignClientUtilSunGlasses feignsunglasses;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/allsunglasses") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<SunGlasses>> getAllSunGlasses(@RequestHeader("Authorization")  String token) throws SunGlassesNotFoundException
    {

        return feignsunglasses.getAllSunGlasses(token);

    }

    @GetMapping("/glasses/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<SunGlasses> getSunGlassesById(@RequestHeader("Authorization")  String token, @PathVariable  Integer id)
    throws FrameNotFoundException{
        return feignsunglasses.getSunGlassesById(token, id);
    }

    @PostMapping("/addglasses") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<SunGlasses> addSunGlasses(@RequestHeader("Authorization")  String token, @RequestBody SunGlasses sunglass)  throws NoProperDataException
    {
        sunglass.setSunGlassId(service.getSequenceNumberForSunGlasses(SunGlasses.SEQUENCE_NAME));

        return feignsunglasses.addSunGlasses(token, sunglass);
    }

//    @PutMapping("/updateframe/{id}")
//    @PreAuthorize( "hasRole('ADMIN')")
//    public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame,@PathVariable Integer id) throws FrameNotFoundException
//    {
//    return feignframe.updateFrame(frame, id);
//    }
   
    @DeleteMapping(path="/sunglasses/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteSunGlasses(@RequestHeader("Authorization")  String token, @PathVariable Integer id) throws SunGlassesNotFoundException {
            return feignsunglasses.deleteSunglasses(token, id);
}
}
