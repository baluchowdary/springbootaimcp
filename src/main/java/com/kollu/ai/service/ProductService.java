package com.kollu.ai.service;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.kollu.ai.model.Product;
import com.kollu.ai.repo.ProductRepo;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	@Tool(description = "Create a new product in the database")
    public Product createProduct(String name, Double price) {
        Product product = new Product();
        product.setProductName(name);
        product.setPrice(price); 
        return productRepo.save(product);
    }
	
	@Tool(description = "Get all existing products")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
	
	@Tool(description = "Update a product price")
    public Product updateProductPrice(String name, Double newPrice) {
		Product product = productRepo.findByProductName(name).orElseThrow();
		product.setPrice(newPrice);
        return productRepo.save(product);
    }
	
	@Tool(description = "Delete a product by name")
    @Transactional
	public String deleteProduct(String name) {
		productRepo.deleteByProductName(name);
        return "Product " + name + " deleted successfully.";
    }
	
	
}
