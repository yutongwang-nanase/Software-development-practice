package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.model.Goods;
import com.example.demo.dao.model.Shop;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopMapper extends BaseMapper<Shop> {

    @Select("select * from shop order by id  desc limit 1")
    List<Shop> selectlast();

    @Select("select * from shop where userid = #{username}")
    List<Shop> selectall(String username);
}
