package br.com.iga.sales.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iga.sales.domain.Sale;
import br.com.iga.sales.repository.SaleRepository;
import br.com.iga.sales.service.SaleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sales")
public class SaleResource {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public List<Sale> listSale(){
		return saleRepository.findAll();
	}
	
	@PostMapping
	public Sale insert(@RequestBody @Valid Sale sale) {
		return saleService.insert(sale);
	}
	
}
