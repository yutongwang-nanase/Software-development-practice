package com.example.demo.server.service.impl;

import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Shop;
import com.example.demo.dao.repo.CarDao;
import com.example.demo.dao.repo.ShopDao;
import com.example.demo.dao.repo.UserDao;
import com.example.demo.server.domain.http.ResultData;
import com.example.demo.server.service.ICarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
@Slf4j
public class CarServicelmpl implements ICarService {

    @Autowired
    CarDao carDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ShopDao shopDao;

    @Override
    public int Savegoods(Car car) {

        return carDao.Savegoods(car.getGoodsid(),car.getUserid(),car.getNum(),car.getPrice(),car.getGoodsname(),car.getPhoto());
    }

    @Override
    public List<Car> getCheckingData(Car car) {
        return carDao.getCheckingData(car.getUserid());
    }

    @Override
    public ResultData Deletegoods(Car car){
        return ResultData.success(carDao.Deletegoods(Math.toIntExact(car.getId())));
    }

    @Override
    public int Checkout(Car car) {
       List<Car> cars = carDao.getCheckingData(car.getUserid());

       int num = 0;
       for (int i=0;i<cars.size();i++){
           num = num+ parseInt(cars.get(i).getPrice())*cars.get(i).getNum();
       }

       // log.info(String.valueOf(num));

        return num;
    }

    @Override
    public int shop(Shop shop) {
        return shopDao.Saveshop(shop.getUserid(),shop.getPoint(),shop.getMoney());
    }

    @Override
    public List<Shop> last() {
        return carDao.last();
    }

    @Override
    public ResultData Deleteall(Car car) {
        return ResultData.success(carDao.Deleteall(car));
    }
}
