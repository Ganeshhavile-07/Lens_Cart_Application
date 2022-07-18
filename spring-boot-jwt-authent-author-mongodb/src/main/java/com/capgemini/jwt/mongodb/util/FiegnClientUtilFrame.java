package com.capgemini.jwt.mongodb.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.capgemini.jwt.mongodb.model.Frame;


@FeignClient(value ="Frame-Service",url ="http://localhost:9002/api/v1")
public  interface FiegnClientUtilFrame {

    @GetMapping("/allframes") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Frame>> getAllFrames(@RequestHeader("Authorization")  String token);


    @GetMapping("/frames/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<Frame> getFrameById(@RequestHeader("Authorization")  String token, Integer id);


    @PostMapping("/addframes") 
    @PreAuthorize(" hasRole('ADMIN')")
    public ResponseEntity<Frame> addFrame(@RequestHeader("Authorization")  String token, Frame frame); 

//    @PutMapping("/updateframe/{id}")
//    public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame,@PathVariable Integer id);

    @DeleteMapping(path="/deleteframes/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<String> deleteFrame(@RequestHeader("Authorization")  String token, Integer id);

    
}