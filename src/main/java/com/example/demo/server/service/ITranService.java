package com.example.demo.server.service;

import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Transaction;

import java.util.List;

public interface ITranService {
    int add(Transaction tran);

    List<Transaction> search(Transaction tran);

    int delete(Transaction tran);

    int check(Transaction tran);

    int money(Transaction tran);

    List<Transaction> commit(Transaction tran);

    List<Transaction> commit2(Transaction tran);

    int enough();

    int demoney();

    List<Money> enough1();
}
