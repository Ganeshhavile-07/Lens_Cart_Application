package com.cg.jwt.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.jwt.models.Glass;

@FeignClient(value ="Glass-Service",url ="http://localhost:9003/api/v1")
public  interface FeignClientUtilGlass {

    @GetMapping("/allglasses") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Glass>> getAllGlasses();


    @GetMapping("/glass/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<Glass> getGlassesById(Integer id);


    @PostMapping("/addglasses") 
    @PreAuthorize(" hasRole('ADMIN')")
    public ResponseEntity<Glass> addGlasses(Glass glass); 

    @PutMapping("/updateglass/{id}")
    public ResponseEntity<Glass> updateGlasses(@RequestBody Glass glasses,@PathVariable Integer id);

    @DeleteMapping(path="/deleteglass/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<String> deleteGlasses(Integer id);

    
}