package uz.pdp.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pdp.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
