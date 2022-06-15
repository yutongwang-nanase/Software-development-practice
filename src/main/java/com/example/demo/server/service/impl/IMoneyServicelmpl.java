package com.example.demo.server.service.impl;

import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Shop;
import com.example.demo.dao.repo.MoneyDao;
import com.example.demo.dao.repo.ShopDao;
import com.example.demo.server.service.IMoneyService;
import com.example.demo.server.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IMoneyServicelmpl implements IMoneyService {


    @Autowired
    MoneyDao moneyDao;

    @Override
    public int insert(Money money) {
        return moneyDao.insert(money);
    }

    @Override
    public List<Money> search(Money money) {
        return moneyDao.search(money);
    }
}
