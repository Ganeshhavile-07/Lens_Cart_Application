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

import com.capgemini.jwt.mongodb.model.Lenses;



@FeignClient(value ="Lenses-Service",url ="http://localhost:9004/api/v1")
public  interface FeignClientUtilLenses {

    @GetMapping("/alllenses") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Lenses>> getAllLenses(@RequestHeader("Authorization")  String token);


    @GetMapping("/lenses/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<Lenses> getLensesById(@RequestHeader("Authorization")  String token, Integer id);


    @PostMapping("/addglenses") 
    @PreAuthorize(" hasRole('ADMIN')")
    public ResponseEntity<Lenses> addLenses(@RequestHeader("Authorization")  String token,Lenses lenses); 

//    @PutMapping("/updateglass/{id}")
//    public ResponseEntity<Lenses> updateLenses(@RequestBody Lenses lenses,@PathVariable Integer id);

    @DeleteMapping(path="/deletelenses/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<String> deleteLenses(@RequestHeader("Authorization")  String token, Integer id);

    
}