package com.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdb.model.Venda;

public interface VendasRepository extends JpaRepository<Venda, Long> {

}
