package com.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdb.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
