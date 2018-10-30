package br.com.iga.sales.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iga.sales.domain.Client;
import br.com.iga.sales.repository.ClientRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientResource {

	@Autowired
	private ClientRepository clientRepository;
	
	//private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> listClient(){
		return ResponseEntity.ok(clientRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Client> registerClient(@RequestBody @Valid Client client) {
		clientRepository.save(client);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Client>> getClientById(@PathVariable long id) {
		Optional<Client> client = clientRepository.findById(id);
		return ResponseEntity.ok().body(client);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> removeClient(@PathVariable long id){
		clientRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable long id){
		Optional<Client> clientOpt = clientRepository.findById(id);		
		if(!clientOpt.isPresent())
			return ResponseEntity.notFound().build();		
		client.setId(id);		
		clientRepository.save(client);		
		return ResponseEntity.noContent().build();
	}
}
