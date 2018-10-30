package br.com.iga.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.iga.sales.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
