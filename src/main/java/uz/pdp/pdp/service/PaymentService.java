package uz.pdp.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import uz.pdp.pdp.entity.Invoice;
import uz.pdp.pdp.entity.Payment;
import uz.pdp.pdp.payload.ApiResponse;
import uz.pdp.pdp.repository.InvoiceRepository;
import uz.pdp.pdp.repository.PaymentRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public ApiResponse makePayment(Integer invoiceId){

        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);

        Payment payment=new Payment();
        Date date=new Date();
        payment.setTime(new Timestamp(date.getTime()));
        payment.setAmount(optionalInvoice.get().getAmount());
        payment.setInvoice(optionalInvoice.get());
        paymentRepository.save(payment);
        return new ApiResponse(true,payment);
    }

    public Payment getOne(Integer id){
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.get();
    }
}
