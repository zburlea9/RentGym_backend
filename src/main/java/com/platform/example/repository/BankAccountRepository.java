package com.platform.example.repository;

import com.platform.example.model.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

    BankAccount findByUserId(Long user_id);

}
