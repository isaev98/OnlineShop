package uz.pdp.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pdp.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
