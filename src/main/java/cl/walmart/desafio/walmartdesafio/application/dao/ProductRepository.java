package cl.walmart.desafio.walmartdesafio.application.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import cl.walmart.desafio.walmartdesafio.domain.Product;

@Repository
@CrossOrigin(origins = "*")
public interface ProductRepository extends MongoRepository<Product, Serializable> {
	/*
	@RestResource(path= "id", rel = "id")
	public List<Product> findById(@Param("id") Integer id, Pageable pageable);
	
	@RestResource(path= "brand", rel = "brand")
	public List<Product> findByBrand(@Param("brand") String brand, Pageable pageable);
	
	@RestResource(path= "description", rel = "description")
	public List<Product> findByDescription(@Param("description") String description, Pageable pageable);//*/
	
	
	@RestResource(path= "id", rel = "id")
	public List<Product> findById(@Param("id") Integer id);
	
	@RestResource(path= "brand", rel = "brand")
	public List<Product> findByBrand(@Param("brand") String brand);
	
	@RestResource(path= "description", rel = "description")
	public List<Product> findByDescription(@Param("description") String description);
	
}
