package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.model.Money;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MoneyMapper extends BaseMapper<Money> {

    @Select("select * from money WHERE user_name = #{username} ")
    List<Money> select(String username);

    @Select("select money from money order by id  desc limit 1")
    int last();

    @Delete("delete from money order by id  desc limit 1")
    int deletelast();

    @Select("select * from money order by id  desc limit 1")
    List<Money> last1();
}
