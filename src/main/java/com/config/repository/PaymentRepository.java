package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
