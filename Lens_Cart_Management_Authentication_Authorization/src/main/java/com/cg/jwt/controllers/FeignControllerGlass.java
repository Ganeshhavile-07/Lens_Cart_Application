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
import com.cg.jwt.exception.GlassNotFoundException;
import com.cg.jwt.exception.NoProperDataException;
import com.cg.jwt.models.Glass;
import com.cg.jwt.security.services.SequenceGeneratorService;
import com.cg.jwt.util.FeignClientUtilGlass;

@RestController
@RequestMapping("/api/v1")
public class FeignControllerGlass {
	@Autowired
    private FeignClientUtilGlass feignglass;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/allglasses") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Glass>> getAllglasses() throws GlassNotFoundException
    {

        return feignglass.getAllGlasses();

    }

    @GetMapping("/glass/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Glass> getGlassById(@PathVariable  Integer id)
    throws FrameNotFoundException{
        return feignglass.getGlassesById(id);
    }

    @PostMapping("/addglasses") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Glass> addGlass(@RequestBody Glass glass)  throws NoProperDataException
    {
        glass.setGlass_id((int) service.getSequenceNumberForGlass(Glass.SEQUENCE_NAME));

        return feignglass.addGlasses(glass);
    }

    @PutMapping("/updateglass/{id}")
    @PreAuthorize( "hasRole('ADMIN')")
    public ResponseEntity<Glass> updateGlass(@RequestBody Glass glass,@PathVariable Integer id) throws GlassNotFoundException
    {
    return feignglass.updateGlasses(glass, id);
    }
   
    @DeleteMapping(path="/deleteglass/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteGlass(@PathVariable Integer id) throws GlassNotFoundException {
            return feignglass.deleteGlasses(id);
}
}