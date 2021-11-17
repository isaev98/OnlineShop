package uz.pdp.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pdp.entity.*;
import uz.pdp.pdp.payload.ApiResponse;
import uz.pdp.pdp.payload.DTO;
import uz.pdp.pdp.payload.OrderDTO;
import uz.pdp.pdp.repository.*;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepositry productRepositry;

    @Autowired
    DetailRepository detailRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    public ApiResponse createOrder(OrderDTO orderDTO){

        Order order=new Order();
        order.setDate(new Date());
        Optional<Customer> optionalCustomer = customerRepository.findById(orderDTO.getCustomerId());
        Customer customer = optionalCustomer.get();
        order.setCustomer(customer);
        orderRepository.save(order);
        Detail detail=new Detail();
        detail.setOrder(order);
        Optional<Product> optionalProduct = productRepositry.findById(orderDTO.getProductId());
        detail.setProduct(optionalProduct.get());
        detail.setQuantity(orderDTO.getQuantity());
        detailRepository.save(detail);
        Invoice invoice=new Invoice();
        invoice.setOrder(order);
        invoice.setIssued(new Date());
        invoice.setDue(new Date(System.currentTimeMillis()+1000*86400*7));
        int amount=0;
        amount = (int) (optionalProduct.get().getPrice()*detail.getQuantity());
        invoice.setAmount(amount);
        invoiceRepository.save(invoice);
        return new ApiResponse(true,invoice.getId());
    }


    public Optional<DTO> getByOrderId(Integer orderId){
        Optional<DTO> byOrderId = orderRepository.getByOrderId(orderId);
        return byOrderId;
    }


}
