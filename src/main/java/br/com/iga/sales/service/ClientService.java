package br.com.iga.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iga.sales.domain.Client;
import br.com.iga.sales.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client insert(Client client) {
		return clientRepository.save(client);
	}
}
