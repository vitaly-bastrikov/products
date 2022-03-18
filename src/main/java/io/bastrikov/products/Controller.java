package io.bastrikov.products;

import io.bastrikov.products.dao.ProductRepository;
import io.bastrikov.products.models.Product;
import io.bastrikov.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/find/{id}")
    public Optional<Product> findById(@PathVariable int id) {
        return productRepository.findById(id);
    }
    @GetMapping("/find")
    public List<Product> findAll(){
        Iterable<Product> iterable = productRepository.findAll();
        List<Product> list = new LinkedList<>();
        iterable.forEach(i -> list.add(i));
        return list;
    }
    @PostMapping("/save")
    public void save(Product product) {
        productRepository.save(product);
    }
    @GetMapping("/generate")
    public String generate(){
        productService.generateProducts();
        return "products were generated";
    }

}
