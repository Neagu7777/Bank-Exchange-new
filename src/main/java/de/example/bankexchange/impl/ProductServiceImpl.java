package de.example.bankexchange.impl;
import de.example.bankexchange.entity.Product;
import de.example.bankexchange.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl {
    @Autowired
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        // Вернуть список всех продуктов
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        // Вернуть продукт по ID, если существует
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        // Создать новый продукт
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        // Удалить продукт по ID
        productRepository.deleteById(id);
    }

    // Дополнительные методы и бизнес-логика по необходимости
}
