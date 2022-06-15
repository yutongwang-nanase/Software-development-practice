package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.model.Goods;
import com.example.demo.dao.model.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface GoodsMapper extends BaseMapper<Goods> {


    @Select("select * from product WHERE status = 1 and product_name LIKE CONCAT ('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<Goods> selectPage(Integer pageNum, Integer pageSize, String name);

    @Select("select count(*) from product WHERE status = 1 and product_name LIKE CONCAT ('%',#{name},'%')")
    Integer selectTotal(String name);

    @Update("update product set purchase_number = #{history},product_stock = #{num} where product_name = #{name}")
    int upgoods(int history,int num  ,String name);

    @Select("select * from product WHERE product_name = #{name} ")
    List<Goods> selectupdate(String name);
//    @Select("select * from goods WHERE id = #{id}")
//    Integer selectId(Integer id);

    @Select("select * from product")
    List<Goods> getAllData();
}

