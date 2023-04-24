package com.example.projectsecurity.Service;

import com.example.projectsecurity.Entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();


    Product getProductByUpc(int upc);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    String deleteProductByUpc(int upc);
}
