package com.cg.ps.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ps.entity.Payment;
import com.cg.ps.exception.NoProperDataException;
import com.cg.ps.exception.PaymentNotFoundException;



public interface Payment_Service {
	public  ResponseEntity<List<Payment>> getAllPayments() throws  PaymentNotFoundException;
	public ResponseEntity<Payment> getPaymentById(@PathVariable int id) throws PaymentNotFoundException;
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment)  throws NoProperDataException;
	public ResponseEntity<Payment> updatePayments(@RequestBody Payment payment ,@PathVariable int id)  throws PaymentNotFoundException;
	public ResponseEntity<String> deletePayments(@PathVariable Integer id) throws PaymentNotFoundException;

}
