package com.example.demo.server.service.impl;

import com.example.demo.dao.mapper.GoodsMapper;
import com.example.demo.dao.model.Goods;
import com.example.demo.dao.model.User;
import com.example.demo.dao.repo.GoodsDao;
import com.example.demo.server.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GoodsServicelmpl implements IGoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> getAllData(){
        return goodsDao.getAllData();
    }

    @Override
    public Map<String, Object> getPage(Integer pageNum, Integer pageSize ,String name) {
        return goodsDao.getPage(pageNum,pageSize,name);
    }

    @Override
    public Integer getShopId(Integer shopid) {
        return null;
    }

    @Override
    public int update(Goods goods) {


        return goodsDao.update(goods.getPurchasenumber(),goods.getProductName());
    }

//    @Override
//    public List<Goods> getShopId(Integer shopid) {
//        return goodsDao.getShopId(shopid);
//    }


}
