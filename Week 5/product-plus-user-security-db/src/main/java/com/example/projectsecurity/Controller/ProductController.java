package com.example.projectsecurity.Controller;

import com.example.projectsecurity.Entity.Product;
import com.example.projectsecurity.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("api/v1/product-controller/public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("<HTML><H1>I am a public user</H1></HTML>");
    }

    @GetMapping("api/v1/product-controller/admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("<HTML><H1>I am an Admin</H1></HTML>");
    }

    @GetMapping("api/v1/product-controller/normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("<HTML><H1>I am a Normal User</H1></HTML>");
    }

    @GetMapping("api/v1/product-controller/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @GetMapping("api/v1/product-controller/products/{upc}")
    public ResponseEntity<Product> getProduct(@PathVariable String upc) {
        return ResponseEntity.ok(this.productService.getProductByUpc(Integer.parseInt(upc)));
    }

    @PostMapping("/api/v1/product-controller/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.addProduct(product));
    }

    @PutMapping("/api/v1/product-controller/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.updateProduct(product));
    }

    @DeleteMapping("/api/v1/product-controller/products/{upc}")
    public ResponseEntity<String> deleteProduct(@PathVariable String upc) {
        return ResponseEntity.ok(this.productService.deleteProductByUpc(Integer.parseInt(upc)));
    }
}
