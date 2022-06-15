package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.GoodsMapper;
import com.example.demo.dao.model.Goods;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoodsDao extends ServiceImpl<GoodsMapper, Goods> {

    @Resource
    private GoodsMapper goodsMapper;

    public List<Goods> getAllData(){

        return goodsMapper.selectList(null);
    }

    public Map<String,Object> getPage(Integer pageNum,Integer pageSize,String name){
        pageNum = (pageNum-1)*pageSize;
        //name ="%"+name+"%";
        List<Goods> data = goodsMapper.selectPage(pageNum,pageSize,name);
        System.out.println(data);

        Integer total = goodsMapper.selectTotal(name);

        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);

        return res;
    }


    public List<Goods> findone(String username){
        List<Goods> data = goodsMapper.selectupdate(username);
        return data;
    }

    public int update(int history, String name) {

        int newhis = findone(name).get(0).getPurchasenumber();

        int newnum = findone(name).get(0).getProductstock();

        int his = history + newhis;

        int n = newnum - history;

     //   int tri = findone(name).get(0).getTrips()+1;

        return goodsMapper.upgoods(his,n,name);


    }

//    public List<Goods> getShopId(@RequestParam Integer shopid){
//       List<Goods> id = goodsMapper.selectId(shopid);
//        return id;
//    }





}
