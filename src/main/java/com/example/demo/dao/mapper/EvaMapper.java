package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.model.Eva;
import com.example.demo.dao.model.Money;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EvaMapper extends BaseMapper<Eva> {


    @Select("select * from evaluation WHERE userid = #{userid} ")
    List<Eva> select(String userid);

    @Update("update evaluation set star = #{star},eva = #{eva} where id = #{id}")
    int upeva(int star,String eva ,int id);

    @Select("select * from evaluation WHERE goodsid = #{goodsid} ")
    List<Eva> selectgoods(int goodsid);
}
