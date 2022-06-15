package com.example.demo.server.service;

import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Shop;

import java.util.List;

public interface IShopService {

    List<Shop> searchid(Shop shop);

    List<Shop> searchall(Shop shop);
}
