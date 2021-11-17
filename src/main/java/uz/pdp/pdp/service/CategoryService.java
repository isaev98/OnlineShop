package uz.pdp.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pdp.entity.Category;
import uz.pdp.pdp.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;



    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getByProductId(Integer productId){
        return categoryRepository.getByProductId(productId);
    }
}
