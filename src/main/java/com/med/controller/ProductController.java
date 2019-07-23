package com.med.controller;

import com.med.model.Product;
import com.med.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api-purshase")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping("/product")

    public Product postCustomer(@RequestBody Product product) {
        return productRepository.save(product);
    }


    @GetMapping("/product/edit/{id}")
    public Product getOne(@PathVariable("id") Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.get() != null) {
            return product.get();
        }
        return null;
    }

    @PutMapping("/product/update/{id}")
    public Product updateChambre(@PathVariable("id") Long id, Product product) {
        Optional<Product> customerLoaded = productRepository.findById(id);
        if (customerLoaded != null) {
            return productRepository.save(product);
        }

        return null;
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Product> deleteCustomer(@PathVariable("id") Long id) {
        Optional<Product> customer = productRepository.findById(id);

        if (customer != null) {
            productRepository.delete(customer.get());
            return new ResponseEntity<Product>(HttpStatus.OK);
        }
        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }


    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


}