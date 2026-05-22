package com.example.it211ss07hw03.service;

import com.example.it211ss07hw03.annotation.RequiresOTP;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @RequiresOTP
    public String withdraw(double amount, String otp) {
        return "Rút tiền thành công";
    }

    @RequiresOTP
    public String transfer(String toUser, double amount, String otp) {
        return "Chuyển khoản thành công";
    }

    public String getBalance(String accountNumber) {
        return "Số dư hiện tại: 1.000.000đ";
    }
}

