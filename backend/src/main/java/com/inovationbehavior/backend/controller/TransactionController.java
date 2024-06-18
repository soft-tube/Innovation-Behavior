package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.annotation.LogAnnotation;
import com.inovationbehavior.backend.model.Result;
import com.inovationbehavior.backend.service.intf.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @LogAnnotation("获取交易信息")
    @GetMapping("")
    public Result getAllTransactions(){
        return Result.success(transactionService.getAllTransactions());
    }

}
