package com.example.demo.server.service;

import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Shop;
import com.example.demo.server.domain.http.ResultData;

import java.util.List;

public interface ICarService {

    int Savegoods(Car car);

    List<Car> getCheckingData(Car car);

    ResultData Deletegoods(Car car);

    int Checkout(Car car);


    int shop(Shop shop);

    List<Shop> last();

    ResultData Deleteall(Car car);
}
