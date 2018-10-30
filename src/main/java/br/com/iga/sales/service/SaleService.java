package br.com.iga.sales.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iga.sales.domain.Sale;
import br.com.iga.sales.repository.ProductRepository;
import br.com.iga.sales.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Sale insert(Sale sale) {
		sale.setRegister(LocalDateTime.now());
		sale.getItems().forEach(i -> {
			i.setSale(sale);
			i.setProduct(productRepository.findById(i.getProduct().getId()).get());
		});
		
			// transforma a lista para bigdecimal, para depois utilizar o metodo reduce para somar todos esses itens
			BigDecimal totalItems = sale.getItems()
					.stream()
					.map(i -> i.getProduct().getAmount().multiply(new BigDecimal(i.getQuatity())))
					.reduce(BigDecimal.ZERO, BigDecimal::add);
			sale.setTotal(totalItems.add(sale.getFreight()));
			
		return saleRepository.save(sale);
	}
}
