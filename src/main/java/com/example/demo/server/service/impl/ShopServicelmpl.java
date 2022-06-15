package com.example.demo.server.service.impl;

import com.example.demo.dao.model.Shop;
import com.example.demo.dao.repo.ShopDao;
import com.example.demo.server.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShopServicelmpl implements IShopService {


    @Autowired
    ShopDao shopDao;

    @Override
    public List<Shop> searchid(Shop shop) {
        return shopDao.findbyid(shop);
    }

    @Override
    public List<Shop> searchall(Shop shop) {
        return shopDao.findall(shop);
    }
}
