package com.mockada.Shopping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockada.Shopping.repository.ProductRepository;

@RestController
@EnableMongoRepositories
public class ShoppingController {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/")
	public String index() {
		return "Welcome";
	}
	
	@GetMapping("/listProducts")
	public String listProducts() {
		List<Product> productList = productRepository.findAll();
	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    try {
	        return objectMapper.writeValueAsString(productList);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "";
	    }
	}
	
    @GetMapping("/addProduct")
    public String addProduct(
    		@RequestParam String name,
    		@RequestParam int quantity,
    		@RequestParam String category) {
    	Product savedProduct = productRepository.save(new Product(name, quantity, category));
        ObjectMapper objectMapper = new ObjectMapper();
	    
	    try {
	        return objectMapper.writeValueAsString(savedProduct);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "";
	    }
    }
    
    @GetMapping("/findProductsByName")
    public String getProductByName(@RequestParam String name) {
    	List<Product> productList = productRepository.findProductsByName(name);
        ObjectMapper objectMapper = new ObjectMapper();
	    
	    try {
	        return objectMapper.writeValueAsString(productList);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "";
	    }
    }
    
    @GetMapping("/findProductsByCategory")
    public String getProductByCategory(@RequestParam String category) {
    	List<Product> productList = productRepository.findProductsByCategory(category);
        ObjectMapper objectMapper = new ObjectMapper();
	    
	    try {
	        return objectMapper.writeValueAsString(productList);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "";
	    }
    }
    
    @GetMapping("/findProductById")
    public String getProductById(@RequestParam String id) {
    	Optional<Product> product = productRepository.findById(id);
        ObjectMapper objectMapper = new ObjectMapper();
	    
	    try {
	        return objectMapper.writeValueAsString(product.get());
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "";
	    }
    }
    
    @GetMapping("/updateProductById")
    public String setProductById(
    		@RequestParam String id,
    		@RequestParam String name,
    		@RequestParam int quantity,
    		@RequestParam String category) {
    	Product newProduct = new Product(name, quantity, category);
    	newProduct.setId(id);
    	Product savedProduct = productRepository.save(newProduct);
        ObjectMapper objectMapper = new ObjectMapper();
	    
	    try {
	        return objectMapper.writeValueAsString(savedProduct);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "";
	    }
    }
}
