package com.platform.example.controller;

import com.platform.example.model.DTO.PaymentDTO;
import com.platform.example.service.PaymentService;
import com.platform.example.validator.BankAccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( value = "/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService, BankAccountValidator bankAccountValidator) {
        this.paymentService = paymentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid PaymentDTO paymentDTO, BindingResult result) {

        if(result.hasErrors()) {
            return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        PaymentDTO save = paymentService.save(paymentDTO);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        paymentService.deletePayment(id);
    }

    @GetMapping("/all")
    public List<PaymentDTO> findAll(){
        return paymentService.findAllPaymentsDTO();
    }

    @GetMapping("/find/{id}")
    public PaymentDTO findById(@PathVariable Long id){return paymentService.findById(id);}

    @GetMapping("/findByUser")
    public PaymentDTO findByUser(@RequestParam Long id){return paymentService.findPaymentByUserId(id);}
}
