package uz.pdp.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.pdp.payload.ApiResponse;
import uz.pdp.pdp.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    public ResponseEntity<?> makePayment(@RequestParam Integer invoiceId){
        ApiResponse apiResponse = paymentService.makePayment(invoiceId);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getDetails(@RequestParam Integer id ){
        return ResponseEntity.ok(paymentService.getOne(id));
    }
}
