package br.com.iga.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.iga.sales.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
