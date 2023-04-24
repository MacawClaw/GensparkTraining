package com.example.ProductDBSecurity.Service;

import com.example.ProductDBSecurity.Dao.ProductDao;
import com.example.ProductDBSecurity.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts(){
        return this.productDao.findAll();
    }

    //UPC used as Id, findById method given by dependencies within findbyUpc
    @Override
    public Product getProductByUpc(int upc){
        Optional <Product> p = this.productDao.findById(upc);
        Product product = null;
        if(p.isPresent()) {
            product = p.get();
        } else {
            throw new RuntimeException("Product not found for upc :: " + upc);
        }

        return product;
    }

    @Override
    public Product addProduct(Product product){
        return this.productDao.save(product);
    }

    @Override
    public Product updateProduct(Product product){
        return this.productDao.save(product);

    }

    @Override
    public String deleteProductByUpc(int upc){
        this.productDao.deleteById(upc);
        return "Deleted Successfully";
    }

}
