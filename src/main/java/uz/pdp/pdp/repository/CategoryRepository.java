package uz.pdp.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.pdp.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select * from category where id=(select category_id from product where product.id=:cat_id)",nativeQuery = true)
    Optional<Category>getByProductId(@Param("cat_id")Integer catId);

}