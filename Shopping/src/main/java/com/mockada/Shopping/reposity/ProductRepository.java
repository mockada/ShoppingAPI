package com.mockada.Shopping.reposity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mockada.Shopping.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	@Query("{ name: '?0' }")
	List<Product> findProductsByName(String name);

	@Query("{ category: '?0' }")
	List<Product> findProductsByCategory(String category);
	
	public long count();
}
