package com.example.ProductDBSecurity.Service;

import com.example.ProductDBSecurity.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();


    Product getProductByUpc(int upc);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    String deleteProductByUpc(int upc);
}
