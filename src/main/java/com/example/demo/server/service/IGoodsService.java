package com.example.demo.server.service;

import com.example.demo.dao.model.Goods;
import com.example.demo.dao.model.User;

import java.util.List;
import java.util.Map;

public interface IGoodsService {
    List<Goods> getAllData();
    Map<String,Object> getPage(Integer pageNum,Integer pageSize,String name);
    Integer getShopId(Integer shopid);

    int update(Goods goods);
}
