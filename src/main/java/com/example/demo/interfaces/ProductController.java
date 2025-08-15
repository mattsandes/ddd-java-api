package com.example.demo.interfaces;

import com.example.demo.application.ProductService;
import com.example.demo.domain.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> listAll() {
        return service.listAll();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product create(@RequestBody Product product) {
        return service.createProduct(
                product.getName(),
                product.getPrice()
        );
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getById(@PathVariable(name = "id") Long id) {
        return service.getById(id);
    }
}
