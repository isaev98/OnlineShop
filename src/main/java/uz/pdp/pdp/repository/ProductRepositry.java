package uz.pdp.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pdp.entity.Category;
import uz.pdp.pdp.entity.Product;

import java.util.Optional;

public interface ProductRepositry extends JpaRepository<Product,Integer> {

}
