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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jwt.exception.FrameNotFoundException;
import com.cg.jwt.exception.NoProperDataException;
import com.cg.jwt.models.Frame;
import com.cg.jwt.security.services.SequenceGeneratorService;
import com.cg.jwt.util.FiegnClientUtilFrame;

@RestController
@RequestMapping("/api/v1")
public class FeignControllerFrame {
 
	@Autowired
    private FiegnClientUtilFrame feignframe;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/allframes") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Frame>> getAllFrames() throws FrameNotFoundException
    {

        return feignframe.getAllFrames();

    }

    @GetMapping("/frames/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Frame> getFrameById(@PathVariable  Integer id)
    throws FrameNotFoundException{
        return feignframe.getFrameById(id);
    }

    @PostMapping("/addframes") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Frame> addFrame(@RequestBody Frame frame)  throws NoProperDataException
    {
        frame.setFrameId(service.getSequenceNumberForFrame(Frame.SEQUENCE_NAME));

        return feignframe.addFrame(frame);
    }

    @PutMapping("/updateframe/{id}")
    @PreAuthorize( "hasRole('ADMIN')")
    public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame,@PathVariable Integer id) throws FrameNotFoundException
    {
    return feignframe.updateFrame(frame, id);
    }
   
    @DeleteMapping(path="/frames/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteFrame(@PathVariable Integer id) throws FrameNotFoundException {
            return feignframe.deleteFrame(id);
}
}
