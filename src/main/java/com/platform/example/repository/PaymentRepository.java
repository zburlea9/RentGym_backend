package com.platform.example.repository;

import com.platform.example.model.entity.BankAccount;
import com.platform.example.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Payment findByUserId(Long user_id);
}
