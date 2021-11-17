package uz.pdp.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.pdp.entity.Order;
import uz.pdp.pdp.payload.DTO;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(nativeQuery = true,value = "select date,customer_id,name from orders inner join detail d on orders.id = d.order_id inner join product p on p.id = d.product_id\n" +
            "where order_id=:order_id")
    Optional<DTO> getByOrderId(@Param("order_id")Integer orderId);
}
