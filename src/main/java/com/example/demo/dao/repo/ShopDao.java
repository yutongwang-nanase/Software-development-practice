package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.CarMapper;
import com.example.demo.dao.mapper.ShopMapper;
import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class ShopDao extends ServiceImpl<ShopMapper, Shop> {

    @Resource
    private ShopMapper shopMapper;


    public int Saveshop( String  userid,String point,String money) {
        Shop shop = new Shop();
        shop.setUserid(userid);
        shop.setPoint(point);
        shop.setMoney(money);

        return shopMapper.insert(shop);
    }

    public List<Shop> findbyid(Shop shop){
        return shopMapper.selectlast();
    }


    public List<Shop> findall(Shop shop) {
        return shopMapper.selectall(shop.getUserid());
    }
}