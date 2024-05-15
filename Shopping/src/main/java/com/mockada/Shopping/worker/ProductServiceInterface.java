package com.mockada.Shopping.worker;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.mockada.Shopping.models.Product;
import com.mockada.Shopping.models.ProductRequest;

public interface ProductServiceInterface {
	ResponseEntity<List<Product>> listProducts();

	ResponseEntity<Product> addProduct(ProductRequest productRequest);

	ResponseEntity<List<Product>> getProductByName(String name);

	ResponseEntity<List<Product>> getProductByCategory(String category);

	ResponseEntity<Optional<Product>> getProductById(String id);

	ResponseEntity<Product> setProductById(ProductRequest productRequest);
}
