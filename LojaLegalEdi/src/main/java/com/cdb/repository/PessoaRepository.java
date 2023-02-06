package com.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdb.model.People;

public interface PessoaRepository extends JpaRepository<People, Long> {

}
