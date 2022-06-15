package com.example.demo.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.model.Goods;
import com.example.demo.dao.model.User;
import com.example.demo.server.domain.http.ResultData;
import com.example.demo.server.service.impl.GoodsServicelmpl;
import com.example.demo.server.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsServicelmpl goodsService;

    @PostMapping("/get")
    public ResultData getAllData() throws Exception {

        List<Goods> userList = goodsService.getAllData();

        if (userList == null) {
            throw new Exception("未获取到数据");
        }
        if (userList.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(userList);
    }

    //分页查询
//    @PostMapping("/page")
//    public Map<String,Object> getPage(@RequestBody Goods goods) throws Exception{
//        Map<String,Object> userList = goodsService.getPage(goods.getPageNum(),goods.getPageSize(),goods.getProductName());
//
//        log.info(String.valueOf(userList));
//        return userList;
//    }



    @GetMapping("/page")
    public Map<String,Object> getPage(Integer pageNum,Integer pageSize,String productname) throws Exception{
        log.info(String.valueOf(pageSize));
        Map<String,Object> userList = goodsService.getPage(pageNum,pageSize,productname);

        log.info(String.valueOf(userList));
        return userList;
    }

//    @GetMapping("/shop")
//    public ResultData getShopId(@RequestParam Integer shopid){
//        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
//
//        return ResultData.success( goodsService.getShopId(shopid));
//    }

    @PostMapping("/update")
    public int update(@RequestBody Goods goods) {
        return goodsService.update(goods);
    }
}
