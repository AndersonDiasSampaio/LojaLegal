package com.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdb.model.Payment;

public interface PagamentoRepository extends JpaRepository<Payment, Long> {

}
