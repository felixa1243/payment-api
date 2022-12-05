package com.iqbalnetwork.repositories;

import com.iqbalnetwork.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Transaction,String> {
}
