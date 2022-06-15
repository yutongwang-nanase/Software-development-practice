package com.example.demo.server.service.impl;

import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Transaction;
import com.example.demo.dao.repo.TranDao;
import com.example.demo.server.service.ITranService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class TranServicelmpl implements ITranService {

    @Autowired
    TranDao tranDao;


    @Override
    public int add(Transaction tran) {
        return tranDao.add(tran);
    }

    @Override
    public List<Transaction> search(Transaction tran) {
        return tranDao.search(tran);
    }

    @Override
    public int delete(Transaction tran) {
        return tranDao.delete(tran);
    }

    @Override
    public int check(Transaction tran) {
        return tranDao.check(tran);
    }

    @Override
    public int money(Transaction tran) {
        return tranDao.money(tran);
    }

    @Override
    public List<Transaction> commit(Transaction tran) {
        return tranDao.commit(tran);
    }

    @Override
    public List<Transaction> commit2(Transaction tran) {
        return tranDao.commit2(tran);
    }

    @Override
    public int enough() {
        return tranDao.enough();
    }

    @Override
    public int demoney() {
        return tranDao.demoney();
    }

    @Override
    public List<Money> enough1() {
        return tranDao.enough1();
    }
}
