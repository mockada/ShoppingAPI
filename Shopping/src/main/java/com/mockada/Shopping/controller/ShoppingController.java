package com.mockada.Shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mockada.Shopping.models.Product;
import com.mockada.Shopping.models.ProductRequest;
import com.mockada.Shopping.worker.ProductServiceInterface;

@RestController
public class ShoppingController {
	@Autowired
	ProductServiceInterface productService;
	
	@GetMapping("/")
	public String index() {
		return "Welcome";
	}
	
	@GetMapping("/listProducts")
	public ResponseEntity<List<Product>> listProducts() {
		return productService.listProducts();
	}
	
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) {
    	return productService.addProduct(productRequest);
    }
    
    @GetMapping("/findProductsByName")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String name) {
    	return productService.getProductByName(name);
    }
    
    @GetMapping("/findProductsByCategory")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam String category) {
    	return productService.getProductByCategory(category);
    }
    
    @GetMapping("/findProductById")
    public ResponseEntity<Optional<Product>> getProductById(@RequestParam String id) {
    	return productService.getProductById(id);
    }
    
    @PostMapping("/updateProductById")
    public ResponseEntity<Product> setProductById(@RequestBody ProductRequest productRequest) {
    	return productService.setProductById(productRequest);
    }
}
