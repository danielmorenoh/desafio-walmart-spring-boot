package cl.walmart.desafio.walmartdesafio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;
import cl.walmart.desafio.walmartdesafio.application.dao.ProductRepository;
import cl.walmart.desafio.walmartdesafio.domain.Product;

@Service
@Transactional
public class ProductService {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
				
		List<Product> productos = productRepository.findAll();

		return aplicarDescuento(productos);
	}
	
	/*public List<Product> findById(int id) {
		
		List<Product> productos = productRepository.findById(id);
		
		List<Product> productos2 = productRepository.findAll();
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		String cadena;
		char[] arrayCadena;
		int descuento = 0; 
		
		
		
		for(Product product : productos) {
			descuento = 0;
			cadena = product.getDescription();
			arrayCadena = cadena.toCharArray();
			
			for(int i = 0; i < arrayCadena.length; i++) {
				map.put(arrayCadena[i],i);		
			}
			
			Set<Entry<Character,Integer>> set = map.entrySet();
			for(Entry<Character,Integer> entry : set) {
				Character xCadena = entry.getKey();
					
				long total=cadena.chars()
					     .mapToObj(i ->(char) i)
					                 .filter((l)->l==xCadena)
					     .count();
				if(total>1) {
					descuento = descuento + 1;
				}
					   // System.out.println(total);	
			}
			
			if(descuento<=5) {
				int porcentaje = descuento*10;
				int precioDscto = product.getPrice()-((porcentaje*product.getPrice())/100);
				product.setDescuento(precioDscto);
			}else {
				int porcentaje = 50;
				int precioDscto = product.getPrice()-((porcentaje*product.getPrice())/100);
				product.setDescuento(precioDscto);
			}
		
		}

		
		List<Product> productos3 = productRepository.findByBrand("Marca1");
		
		String x = "Hola";
		
		return productos;
	}//*/
	

	public List<Product> aplicarDescuento(List<Product> productos){
		HashMap<Character, Integer> map = new HashMap<>();
		String cadena;
		char[] arrayCadena;
		int descuento = 0; 
		
		for(Product product : productos) {
			descuento = 0;
			cadena = product.getDescription().replace(" ", "");
			arrayCadena = cadena.toCharArray();
			
			for(int i = 0; i < arrayCadena.length; i++) {
				map.put(arrayCadena[i],i);		
			}
			
			Set<Entry<Character,Integer>> set = map.entrySet();
			for(Entry<Character,Integer> entry : set) {
				Character caracter = entry.getKey();
					
				long total=cadena.chars()
					     .mapToObj(i ->(char) i)
					                 .filter((l)->l==caracter)
					     .count();
				if(total>1) {
					descuento = descuento + 1;
				}
			}
			
			if(descuento<=5) {
				int porcentaje = descuento*10;
				int precioDscto = product.getPrice()-((porcentaje*product.getPrice())/100);
				product.setDescuento(precioDscto);
			}else {
				int porcentaje = 50;
				int precioDscto = product.getPrice()-((porcentaje*product.getPrice())/100);
				product.setDescuento(precioDscto);
			}		
		}

		return productos;
	}
}
