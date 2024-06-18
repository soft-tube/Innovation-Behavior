package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;

@Mapper
public interface TransactionMapper {
    @Select("""
    SELECT * FROM transaction;
""")
    List<Transaction> getAllTransactions();
}
