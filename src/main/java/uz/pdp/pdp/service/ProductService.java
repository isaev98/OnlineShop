package uz.pdp.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pdp.entity.Product;
import uz.pdp.pdp.repository.ProductRepositry;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepositry productRepositry;

    public List<Product> getAll(){
        return productRepositry.findAll();
    }

    public Optional<Product> getById(Integer productId){
        return productRepositry.findById(productId);
    }
}
