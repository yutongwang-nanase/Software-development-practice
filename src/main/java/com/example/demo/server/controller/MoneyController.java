package com.example.demo.server.controller;

import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Shop;
import com.example.demo.dao.model.User;
import com.example.demo.server.service.impl.IMoneyServicelmpl;
import com.example.demo.server.service.impl.ShopServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    IMoneyServicelmpl moneyServicelmpl;


    @PostMapping("/insertmoney")
    public int insertmoney(@RequestBody Money money){
        return moneyServicelmpl.insert(money);
    }

    @PostMapping
    public List<Money> search(@RequestBody Money money){
        return moneyServicelmpl.search(money);
    }


}
