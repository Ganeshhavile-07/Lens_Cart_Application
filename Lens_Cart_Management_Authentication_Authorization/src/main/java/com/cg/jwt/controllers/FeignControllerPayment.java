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
import com.cg.jwt.exception.FrameNotFoundException;
import com.cg.jwt.exception.NoProperDataException;
import com.cg.jwt.exception.PaymentNotFoundException;
import com.cg.jwt.models.Payment;
import com.cg.jwt.security.services.SequenceGeneratorService;
import com.cg.jwt.util.FeignClientUtilPayment;

public class FeignControllerPayment {
    
	@Autowired
    private FeignClientUtilPayment feignpayment;


    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/allpayments") 
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<List<Payment>> getAllPayment() throws PaymentNotFoundException
    {

        return feignpayment.getAllPayments();

    }

    @GetMapping("/payments/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Payment> getPaymentById(@PathVariable  Integer id)
    throws FrameNotFoundException{
        return feignpayment.getPaymentById(id);
    }
    
    @PostMapping("/addpayments") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment)  throws NoProperDataException
    {
        payment.setPaymentId((int) service.getSequenceNumberForPayment(Payment.SEQUENCE_NAME));
   
        return feignpayment.addPayment(payment);
    }
    
    @PutMapping("/updatepayment/{id}")
    @PreAuthorize( "hasRole('ADMIN')")
    public ResponseEntity<Payment> updatePayments(@RequestBody Payment payments,@PathVariable Integer id) throws PaymentNotFoundException
    {
    return feignpayment.updatePayments(payments, id);
    }
    
    @DeleteMapping(path="/deletepayment/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deletePayment(@PathVariable Integer id) throws PaymentNotFoundException {
            return feignpayment.deletePayments(id);
}   

}
