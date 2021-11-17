package uz.pdp.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp.payload.ApiResponse;
import uz.pdp.pdp.payload.DTO;
import uz.pdp.pdp.payload.OrderDTO;
import uz.pdp.pdp.service.OrderService;

import javax.persistence.GeneratedValue;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?>makeOrder(@RequestBody OrderDTO orderDTO){
        ApiResponse apiResponse = orderService.createOrder(orderDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }


    @GetMapping("/detail")
    public ResponseEntity<?>getByOrderId(@RequestParam Integer orderId){
        Optional<DTO> optionalDTO = orderService.getByOrderId(orderId);
        return ResponseEntity.ok(optionalDTO);
    }
}
