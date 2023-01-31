package com.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cdb.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	@Modifying
	@Query(value = "update produto u set u.description = ? where u.sku = ?", nativeQuery = true)
	int updateProdutoSku(String description , String sku);
	Produto findBySku(String sku);
	Long deleteBySku(String sku);
}
