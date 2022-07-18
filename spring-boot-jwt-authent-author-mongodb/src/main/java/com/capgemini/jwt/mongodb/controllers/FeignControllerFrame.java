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
import com.capgemini.jwt.mongodb.exception.FrameNotFoundException;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.model.Frame;
import com.capgemini.jwt.mongodb.util.FiegnClientUtilFrame;


@RestController
@RequestMapping("/api/v1")
public class FeignControllerFrame {
 
	@Autowired
    private FiegnClientUtilFrame feignframe;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/allframes") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Frame>> getAllFrames(@RequestHeader("Authorization")  String token) throws FrameNotFoundException
    {

        return feignframe.getAllFrames(token);

    }

    @GetMapping("/frames/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Frame> getFrameById(@RequestHeader("Authorization")  String token, @PathVariable  Integer id)
    throws FrameNotFoundException{
        return feignframe.getFrameById(token, id);
    }

    @PostMapping("/addframes") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Frame> addFrame(@RequestHeader("Authorization")  String token, @RequestBody Frame frame)  throws NoProperDataException
    {
        frame.setFrameId(service.getSequenceNumberForFrame(Frame.SEQUENCE_NAME));

        return feignframe.addFrame(token, frame);
    }

//    @PutMapping("/updateframe/{id}")
//    @PreAuthorize( "hasRole('ADMIN')")
//    public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame,@PathVariable Integer id) throws FrameNotFoundException
//    {
//    return feignframe.updateFrame(frame, id);
//    }
   
    @DeleteMapping(path="/frames/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteFrame(@RequestHeader("Authorization")  String token, @PathVariable Integer id) throws FrameNotFoundException {
            return feignframe.deleteFrame(token, id);
}
}
