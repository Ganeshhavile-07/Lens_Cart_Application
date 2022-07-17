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
import com.cg.jwt.models.Payment;

@FeignClient(value ="Payment-Service",url ="http://localhost:9008/api/v1")
public  interface FeignClientUtilPayment {

    @GetMapping("/allpayments") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Payment>> getAllPayments();


    @GetMapping("/payment/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<Payment> getPaymentById(Integer id);


    @PostMapping("/addpayments") 
    @PreAuthorize(" hasRole('ADMIN')")
    public ResponseEntity<Payment> addPayment(Payment payment); 

    @PutMapping("/updatepayment/{id}")
    public ResponseEntity<Payment> updatePayments(@RequestBody Payment payments,@PathVariable Integer id);

    @DeleteMapping(path="/deletepayment/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<String> deletePayments(Integer id);
    
} 