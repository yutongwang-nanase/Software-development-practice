package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.CarMapper;
import com.example.demo.dao.mapper.MoneyMapper;
import com.example.demo.dao.mapper.ShopMapper;
import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class MoneyDao extends ServiceImpl<MoneyMapper, Money> {

    @Resource
    private MoneyMapper mapper;

    public int insert(Money money) {
        return mapper.insert(money);
    }

    public List<Money> search(Money money) {
        return mapper.select(money.getUsername());
    }
}