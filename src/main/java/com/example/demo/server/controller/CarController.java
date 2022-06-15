package com.example.demo.server.controller;

import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Shop;
import com.example.demo.dao.model.User;
import com.example.demo.server.domain.http.ResultData;
import com.example.demo.server.service.impl.CarServicelmpl;
import com.example.demo.server.service.impl.GoodsServicelmpl;
import com.example.demo.server.service.impl.ShopServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarServicelmpl CarService;




    @PostMapping
    public int savegoods(@RequestBody Car car) {

        log.info(String.valueOf(car));
        return CarService.Savegoods(car);
    }
    @PostMapping("/search")
    public ResultData getCheckingData(@RequestBody Car car) throws Exception {
        List<Car> carList = CarService.getCheckingData(car);

        log.info(String.valueOf(carList));
        if (carList == null) {
            throw new Exception("未获取到数据");
        }
        return ResultData.success(carList);
    }

    @PostMapping("/delete")
    public ResultData Deletegoods(@RequestBody Car car) throws Exception{
      //  log.info(String.valueOf(car));
        return CarService.Deletegoods(car);
    }

    @PostMapping("/check")
    public int Checkgoods(@RequestBody Car car) throws Exception{
       // log.info(String.valueOf(car));
        return CarService.Checkout(car);
    }

    @PostMapping("/shop")
    public int Shop(@RequestBody Car car) throws Exception{
      //  log.info(String.valueOf(car));
        int money = CarService.Checkout(car);
        int point = money / 100;
        Shop shop = new Shop();
        shop.setUserid(car.getUserid());
        shop.setMoney(String.valueOf(money));
        shop.setPoint(String.valueOf(point));

        return CarService.shop(shop);

    }

    @PostMapping("/deleteall")
    public ResultData Deleteall(@RequestBody Car car) throws Exception{
        log.info(String.valueOf(car));
        return CarService.Deleteall(car);
    }

    @PostMapping("/last")
    public List<Shop> last() throws Exception{

        return CarService.last();
    }


}
