package com.example.demo.infrastructure.persistence;

import com.example.demo.domain.model.Product;
import com.example.demo.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity();

        entity.setName(product.getName());
        entity.setPrice(product.getPrice());

        var savedProduct = productJpaRepository.save(entity);

        return new Product(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice()
        );
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll()
                .stream()
                .map(e -> new Product(
                        e.getId(),
                        e.getName(),
                        e.getPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id)
                .map(e -> new Product(
                        e.getId(),
                        e.getName(),
                        e.getPrice()
                ));
    }
}
