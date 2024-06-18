package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
}
