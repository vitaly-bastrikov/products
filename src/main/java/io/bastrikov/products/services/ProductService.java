package io.bastrikov.products.services;

import io.bastrikov.products.dao.ProductRepository;
import io.bastrikov.products.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductRepository productRepository;
    List<String> categories = new ArrayList<>(Arrays.asList("food", "electronics", "clothes", "sports"));

    public void generateProducts() {
        List<Product> productList = new LinkedList<>();
        productList.add(new Product(1, "apple", 22.51, "food"));
        productList.add(new Product(2, "orange", 12.51, "food"));
        productList.add(new Product(3, "banana", 32.51, "food"));
        productList.add(new Product(4, "Iphone", 872.51, "electronics"));
        productList.add(new Product(5, "Samsung", 519.51, "electronics"));
        productList.add(new Product(6, "XBox", 399.51, "electronics"));
        productList.add(new Product(7, "PS5", 12.51, "electronics"));
        productList.add(new Product(8, "TShirt", 11.38, "clothes"));
        productList.add(new Product(9, "cap", 4.87, "clothes"));
        productList.add(new Product(10, "jeans", 78.32, "clothes"));

        for(Product product: productList) {
            productRepository.save(product);
        }
        logger.info("generating finished");
    }
}
