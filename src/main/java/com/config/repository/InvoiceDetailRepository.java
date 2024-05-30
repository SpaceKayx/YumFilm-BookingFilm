package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

}
