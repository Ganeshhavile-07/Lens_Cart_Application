package com.cg.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ps.entity.Payment;
import com.cg.ps.exception.NoProperDataException;
import com.cg.ps.exception.PaymentNotFoundException;
import com.cg.ps.serviceimpl.PaymentServiceImpl;
import com.cg.ps.serviceimpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class PaymentController {
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/allpayment")
	public ResponseEntity<List<Payment>> getAllPayments() throws PaymentNotFoundException {
		log.info("starting  of get mapping");
		return paymentServiceImpl.getAllPayments();

	}

	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id) throws PaymentNotFoundException {
		return paymentServiceImpl.getPaymentById(id);
	}

	@PostMapping("/addpayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) throws NoProperDataException {
		log.info("start");
		payment.setPaymentId(sequenceGeneratorService.getSequenceNumberForPayment(Payment.SEQUENCE_NAME));
		return paymentServiceImpl.addPayment(payment);
	}

	@PutMapping("/updatepayment/{id}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable int id)
			throws PaymentNotFoundException {
		return paymentServiceImpl.updatePayments(payment, id);
	}

	@DeleteMapping(path = "/deletepayments/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable int id) throws PaymentNotFoundException {
		return paymentServiceImpl.deletePayments(id);
	}

}
