package com.mockada.Shopping.worker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mockada.Shopping.models.Product;
import com.mockada.Shopping.models.ProductRequest;
import com.mockada.Shopping.repository.ProductRepository;

@Component
public class ProductService implements ProductServiceInterface {
	@Autowired
	ProductRepository productRepository;

	public ResponseEntity<List<Product>> listProducts() {
		List<Product> productList = productRepository.findAll();
		return ResponseEntity.ok(productList);
	}

	public ResponseEntity<Product> addProduct(ProductRequest productRequest) {
		Product savedProduct = productRepository.save(productRequest.getProduct());
		return ResponseEntity.ok(savedProduct);
	}

	public ResponseEntity<List<Product>> getProductByName(String name) {
		List<Product> productList = productRepository.findProductsByName(name);
		return ResponseEntity.ok(productList);
	}

	public ResponseEntity<List<Product>> getProductByCategory(String category) {
		List<Product> productList = productRepository.findProductsByCategory(category);
		return ResponseEntity.ok(productList);
	}

	public ResponseEntity<Optional<Product>> getProductById(String id) {
		Optional<Product> product = productRepository.findById(id);
		return ResponseEntity.ok(product);
	}

	public ResponseEntity<Product> setProductById(ProductRequest productRequest) {
		Product newProduct = productRequest.getProduct();
		newProduct.setId(productRequest.getId());
		Product savedProduct = productRepository.save(newProduct);
		return ResponseEntity.ok(savedProduct);
	}
}
