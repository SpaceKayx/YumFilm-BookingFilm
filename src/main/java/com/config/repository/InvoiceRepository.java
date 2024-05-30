package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
