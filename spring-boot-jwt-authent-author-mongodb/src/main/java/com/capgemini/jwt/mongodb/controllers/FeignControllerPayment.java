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

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.exception.PaymentNotFoundException;
import com.capgemini.jwt.mongodb.model.Payment;
import com.capgemini.jwt.mongodb.util.FeignClientUtilPayment;

public class FeignControllerPayment {
    
	@Autowired
    private FeignClientUtilPayment feignpayment;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/allpayments") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Payment>> getAllPayment(@RequestHeader("Authorization")  String token) throws PaymentNotFoundException
    {

        return feignpayment.getAllPayments(token);

    }

    @GetMapping("/payments/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Payment> getPaymentById(@RequestHeader("Authorization")  String token, @PathVariable  Integer id)
    throws PaymentNotFoundException{
        return feignpayment.getPaymentById(token, id);
    }
    
    @PostMapping("/addpayments") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Payment> addPayment(@RequestHeader("Authorization")  String token, @RequestBody Payment payment)  throws NoProperDataException
    {
        payment.setPaymentId((int) service.getSequenceNumberForPayment(Payment.SEQUENCE_NAME));
   
        return feignpayment.addPayment(token, payment);
    }
    
//    @PutMapping("/updatepayment/{id}")
//    @PreAuthorize( "hasRole('ADMIN')")
//    public ResponseEntity<Payment> updatePayments(@RequestBody Payment payments,@PathVariable Integer id) throws PaymentNotFoundException
//    {
//    return feignpayment.updatePayments(payments, id);
//    }
    
    @DeleteMapping(path="/deletepayment/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deletePayment(@RequestHeader("Authorization")  String token, @PathVariable Integer id) throws PaymentNotFoundException {
            return feignpayment.deletePayments(token, id);
}   

}
