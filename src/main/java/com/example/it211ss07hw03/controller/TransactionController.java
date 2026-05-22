package com.example.it211ss07hw03.controller;

import com.example.it211ss07hw03.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount,
                           @RequestParam(required = false) String otp) {
        return transactionService.withdraw(amount, otp);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String toUser,
                           @RequestParam double amount,
                           @RequestParam(required = false) String otp) {
        return transactionService.transfer(toUser, amount, otp);
    }

    @GetMapping("/balance")
    public String getBalance(@RequestParam String accountNumber) {
        return transactionService.getBalance(accountNumber);
    }
}

