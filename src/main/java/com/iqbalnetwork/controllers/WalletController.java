package com.iqbalnetwork.controllers;

import com.iqbalnetwork.Models.Response.SuccessResponse;
import com.iqbalnetwork.Models.Transaction;
import com.iqbalnetwork.Models.requests.TransactionRequest;
import com.iqbalnetwork.repositories.WalletRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/wallet-payment")
public class WalletController {
    @Autowired
    WalletRepo repo;
    ModelMapper mapper = new ModelMapper();
    UUID uuid = UUID.randomUUID();

    @PostMapping
    public ResponseEntity payment(@Valid @RequestBody TransactionRequest trx) throws Exception {
        Transaction payments = mapper.map(trx, Transaction.class);
//        if ((!trx.getTransactionId().equals("123")) || (!trx.getTransactionType().equals("PAYMENT")) || (!trx.getCustomerId().equals("123"))) {
//            throw new NotValidPaymentException();
//        }
        repo.save(payments);
        return ResponseEntity
                .status(201)
                .body(new SuccessResponse<>("00", "Success payment", uuid.toString()));
    }

}
