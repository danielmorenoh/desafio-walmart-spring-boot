package cl.walmart.desafio.walmartdesafio.ui;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cl.walmart.desafio.walmartdesafio.domain.Product;
import cl.walmart.desafio.walmartdesafio.service.ProductService;

@RestController
@RequestMapping(value = "/productos")
@CrossOrigin(origins = "*")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/obtener", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		try {
			List<Product> productos = productService.findAll();
			if (productos != null) {
				return ResponseEntity.status(HttpStatus.OK).body(productos);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
