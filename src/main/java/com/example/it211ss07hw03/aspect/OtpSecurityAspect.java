package com.example.it211ss07hw03.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OtpSecurityAspect {

    @Around("@annotation(com.example.it211ss07hw03.annotation.RequiresOTP)")
    public Object verifyOtp(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String otp = null;

        // Giả sử OTP luôn là tham số cuối cùng
        if (args.length > 0 && args[args.length - 1] instanceof String) {
            otp = (String) args[args.length - 1];
        }

        if (otp == null || otp.trim().isEmpty()) {
            throw new RuntimeException("OTP không được để trống!");
        }

        if (!"123456".equals(otp)) { // giả lập verify OTP
            throw new RuntimeException("Sai OTP, giao dịch bị từ chối!");
        }

        return joinPoint.proceed();
    }
}

