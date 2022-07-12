package com.cg.ps.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ps.entity.Payment;
import com.cg.ps.exception.NoProperDataException;
import com.cg.ps.exception.PaymentNotFoundException;
import com.cg.ps.repository.Payment_repository;
import com.cg.ps.service.Payment_Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PaymentServiceImpl implements Payment_Service {
@Autowired
	private Payment_repository payment_repository;
	@Override
	public ResponseEntity<List<Payment>> getAllPayments() throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all paymentss from here");
		return new  ResponseEntity<>(payment_repository.findAll(),HttpStatus.OK);
	
	
	}

	@Override
	public ResponseEntity<Payment> getPaymentById(int id) throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		Payment payments=payment_repository.findById(id).orElseThrow(()-> new  PaymentNotFoundException("payment Not Found"+id));

		return ResponseEntity.ok().body(payments);
	}	

	@Override
	public ResponseEntity<Payment> addPayment(Payment payment) throws NoProperDataException {
		// TODO Auto-generated method stub
		log.info("start");
		if(payment!=null) 
		{
			payment_repository.save(payment);
			System.out.println("payment added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(payment);
	}	

	@Override
	public ResponseEntity<Payment> updatePayments(Payment payment, int id) throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		Payment payments=payment_repository.findById(id).orElseThrow(()-> new PaymentNotFoundException("seed not "+id));
		
		payments.setPaymentType(payment.getPaymentType());;
		
		
		
		final Payment updatedPayment = payment_repository.save(payment);
		return ResponseEntity.ok(updatedPayment);	}

	@Override
	public ResponseEntity<String> deletePayments(Integer id) throws PaymentNotFoundException {
		log.info("Start delete");
		var isRemoved =payment_repository.findById(id);
		if(isRemoved.isPresent())
		{
			payment_repository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new PaymentNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return ResponseEntity.ok(id+" deleted successfully");
	}

}
