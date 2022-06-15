package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.CarMapper;
import com.example.demo.dao.mapper.ShopMapper;
import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Goods;
import com.example.demo.dao.model.Shop;
import com.example.demo.dao.model.User;
import com.example.demo.server.domain.http.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class CarDao extends ServiceImpl<CarMapper, Car> {

    @Resource
    private CarMapper carMapper;

    @Resource
    private ShopMapper shopMapper;

    public int Savegoods( String goodsid, String  userid, int num,String price,String goodsname,String photo) {
            Car car = new Car();
            car.setGoodsid(goodsid);
            car.setUserid(userid);
            car.setNum(num);
            car.setPrice(price);
        car.setGoodsname(goodsname);
        car.setPhoto(photo);
        return carMapper.insert(car);
    }




    public List<Car> getCheckingData(String userid) {
        QueryWrapper<Car> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userid);
//        List<Car> cars = carMapper.selectList(wrapper);
//        log.info("cars:{}" + cars);
        return carMapper.selectList(wrapper);
    }

    public int Deletegoods(int id){
        Car car = new Car();
        car.setId(id);
        return carMapper.deleteById(car);
    }

    public int Deleteall(Car car) {
        return carMapper.deletebyname(car.getUserid());
    }

    public List<Shop> last(){
        return shopMapper.selectlast();
    }



//    public List<Car> Checkout(String userid){
//        QueryWrapper<Car> wrapper = new QueryWrapper<>();
//        wrapper.eq("userid", userid);
//        List<Car> cars = carMapper.selectList(wrapper);
////        log.info("cars:{}" + cars);
//        return carMapper.selectList(wrapper);
//    }


}