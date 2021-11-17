package uz.pdp.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.pdp.entity.Category;
import uz.pdp.pdp.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public HttpEntity<?> getAll(){
        List<Category> allCategories = categoryService.getAll();
        return ResponseEntity.ok(allCategories);
    }

    @GetMapping
    public HttpEntity<?> getOne(@RequestParam Integer productId ){
        Optional<Category> optionalCategory = categoryService.getByProductId(productId);
        return ResponseEntity.ok(optionalCategory);
    }
}
