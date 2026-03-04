package com.kollu.ai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kollu.ai.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	Optional<Product> findByProductName(String productName);

	void deleteByProductName(String productName);  

}
