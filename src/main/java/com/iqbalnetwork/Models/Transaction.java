package com.iqbalnetwork.Models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "m_trx")
@Data
public class Transaction {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "transaction_type")
    private String transactionType;
}
