package br.com.iga.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.iga.sales.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
