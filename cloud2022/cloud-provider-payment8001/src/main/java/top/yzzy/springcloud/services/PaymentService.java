package top.yzzy.springcloud.services;

import top.yzzy.springcloud.entities.Payment;

public interface PaymentService {

    Payment queryById(Long id);

    Integer insert(Payment payment);
}
