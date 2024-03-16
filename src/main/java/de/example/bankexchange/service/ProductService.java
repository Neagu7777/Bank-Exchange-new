package de.example.bankexchange.service;

import de.example.bankexchange.entity.Product;
import de.example.bankexchange.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Метод для получения всех продуктов
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Метод для получения продукта по ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Метод для создания нового продукта
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Метод для удаления продукта по ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // Другие методы, если необходимо
}