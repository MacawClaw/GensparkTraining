package com.example.ProductDBSecurity.Controller;

import com.example.ProductDBSecurity.Entity.Product;
import com.example.ProductDBSecurity.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/public")
    public String publicUser(){ return "<HTML><H1>I am a public user</H1></HTML>"; }

    @GetMapping("/admin")
    public String adminUser(){
        return "<HTML><H1>I am an Admin</H1></HTML>";
    }

    @GetMapping("/normal")
    public String normalUser(){
        return "<HTML><H1>I am a Normal User</H1></HTML>";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/products/{upc}")
    public Product getProduct(@PathVariable String upc) {
        return this.productService.getProductByUpc(Integer.parseInt(upc));
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("/products/{upc}")
    public String deleteProduct(@PathVariable String upc) {
        return this.productService.deleteProductByUpc(Integer.parseInt(upc));
    }
}
