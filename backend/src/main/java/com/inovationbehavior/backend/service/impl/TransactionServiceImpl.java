package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.TransactionMapper;
import com.inovationbehavior.backend.model.Transaction;
import com.inovationbehavior.backend.service.intf.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionMapper.getAllTransactions();
    }
}
