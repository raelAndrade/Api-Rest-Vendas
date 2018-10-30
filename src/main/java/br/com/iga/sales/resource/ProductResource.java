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

import br.com.iga.sales.domain.Product;
import br.com.iga.sales.repository.ProductRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductResource {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> listProduct(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable long id){
		Optional<Product> product = productRepository.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping
	public ResponseEntity<Product> registerProduct(@RequestBody @Valid Product product){
		productRepository.save(product);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> removeProduct(@PathVariable long id){
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id){
		Optional<Product> productOpt = productRepository.findById(id);
		
		if(!productOpt.isPresent())
			return ResponseEntity.notFound().build();
		product.setId(id);
		productRepository.save(product);
		return ResponseEntity.noContent().build();
	}
 }
