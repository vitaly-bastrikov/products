package io.bastrikov.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentService {
    @Autowired
    ProductService productService;

    public void generate(){
        productService.generateProducts();
    }
}
