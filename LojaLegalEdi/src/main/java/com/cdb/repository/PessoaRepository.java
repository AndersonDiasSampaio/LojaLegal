package com.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdb.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
