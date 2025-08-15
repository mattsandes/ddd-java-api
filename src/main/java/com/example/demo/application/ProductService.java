package com.example.demo.application;

import com.example.demo.domain.model.Product;
import com.example.demo.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public Product createProduct(String name, double price) {
        Product product = new Product(null, name, price);

        return repository.save(product);
    }

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
    }
}
