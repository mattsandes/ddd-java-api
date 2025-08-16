package com.example.demo.unitests.application;

import com.example.demo.application.ProductService;
import com.example.demo.domain.model.Product;
import com.example.demo.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Teste Product", 3.5);
    }

    @Test
    @DisplayName("Validar que é possivel listar os produtos criados")
    public void ListAllShowCreatedProduct_When_List() {
        when(repository.findAll()).thenReturn(List.of(product));

        var result = service.listAll();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Validar que é possivel criar novos produtos")
    public void ValidateThatANewProductIsCreate_When_CreateProduct() {
        Product produtoEntradaLaEle = new Product(null, "produto entrada", 9.9);
        Product produtoSaida = new Product(1L, "produto saida", 9.9);

        when(repository.save(produtoEntradaLaEle)).thenReturn(produtoSaida);

        var result = service.createProduct(produtoEntradaLaEle.getName(), produtoEntradaLaEle.getPrice());

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("produto saida", result.getName());
        assertEquals(9.9, result.getPrice());
    }

    @Test
    @DisplayName("Validar que é possivel listar um produto pelo id")
    public void ValidateThatAProductIsReturned_When_FindById() {
        when(repository.findById(product.getId())).thenReturn(Optional.of(product));

        var result = service.getById(1L);

        assertNotNull(result);
        assertEquals("Teste Product", result.getName());
        assertEquals(3.5, result.getPrice());
    }
}