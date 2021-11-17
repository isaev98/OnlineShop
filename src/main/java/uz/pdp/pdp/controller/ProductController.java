package uz.pdp.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.pdp.entity.Product;
import uz.pdp.pdp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    public ResponseEntity<?>getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    public ResponseEntity<?>getOneById(@RequestParam Integer productId){
        return ResponseEntity.ok(productService.getById(productId));
    }
}
