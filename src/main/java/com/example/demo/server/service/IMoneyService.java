package com.example.demo.server.service;

import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Shop;

import java.util.List;

public interface IMoneyService {


    int insert(Money money);

    List search(Money money);
}
