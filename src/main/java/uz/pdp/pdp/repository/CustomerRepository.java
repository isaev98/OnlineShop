package uz.pdp.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pdp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
