package com.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdb.model.Sell;

public interface VendasRepository extends JpaRepository<Sell, Long> {

}
