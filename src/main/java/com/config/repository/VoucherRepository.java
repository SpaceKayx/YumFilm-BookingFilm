package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

}
