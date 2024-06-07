package com.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Payment;
import com.config.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment selectById(int id)
	{
		Payment payment = paymentRepository.findById(id).get();
		if(payment != null)
			return payment;
		return null;
	}
}
