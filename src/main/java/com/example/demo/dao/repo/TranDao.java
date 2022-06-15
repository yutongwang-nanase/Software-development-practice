package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.MoneyMapper;
import com.example.demo.dao.mapper.TranMapper;
import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class TranDao extends ServiceImpl<TranMapper, Transaction> {
    @Resource
    private TranMapper tranMapper;

    @Resource
    private MoneyMapper moneyMapper;

    public int add(Transaction tran) {
       return tranMapper.insert(tran);
    }

    public List<Transaction> search(Transaction tran) {
        return tranMapper.search(tran.getPayer());
    }

    public int delete(Transaction tran) {
        return tranMapper.deleteById(tran.getId());
    }

    public int check(Transaction tran) {
        return tranMapper.check(tran.getPayer());
    }

    public int money(Transaction tran) {
        List<Transaction> data = tranMapper.search(tran.getPayer());


        int money1 = 0;
        for (int i = 0;i<data.size();i++){
            int money = data.get(i).getMoney();


            money1 = money1+money;

        }
        int point = money1 / 10000;
        Money money = new Money();
        money.setMoney(money1);
        money.setPoint(point);
        money.setUsername(tran.getPayer());
        return moneyMapper.insert(money);


    }

    public List<Transaction> commit(Transaction tran) {
        return tranMapper.selectTotal(tran.getPayer());
    }
    public List<Transaction> commit2(Transaction tran) {
        return tranMapper.selectTotal2(tran.getPayer());
    }

    public int enough() {
        return moneyMapper.last();
    }

    public int demoney() {
        return moneyMapper.deletelast();
    }

    public List<Money> enough1() {
        return moneyMapper.last1();
    }
}
