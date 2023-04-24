package com.example.productsecurity.Controller;

import com.example.productsecurity.Entity.Product;
import com.example.productsecurity.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("<HTML><H1>I am a public user</H1></HTML>");
    }

    //@MustBeAdmin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("<HTML><H1>I am an Admin</H1></HTML>");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("<HTML><H1>I am a Normal User</H1></HTML>");
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("products/{upc}")
    public ResponseEntity<Product> getProduct(@PathVariable String upc) {
        return ResponseEntity.ok(this.productService.getProductByUpc(Integer.parseInt(upc)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.addProduct(product));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.updateProduct(product));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("products/{upc}")
    public ResponseEntity<String> deleteProduct(@PathVariable String upc) {
        return ResponseEntity.ok(this.productService.deleteProductByUpc(Integer.parseInt(upc)));
    }
}
