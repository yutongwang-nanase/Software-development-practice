package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {


//    @Select("Insert into user(username,password,phonenum,email,city,gender,account,type) VALUES (#{username},#{password},#{phonenum},#{email},#{city},#{gender},#{account},#{type}); ")
//    int insert(User user);
        @Select("select * from user WHERE name = #{username} ")
        List<User> selectTotal(String username);

        @Update("update user set income = #{money},point = #{point} where username = #{username}")
        int upshop(int money,int point ,String username);

        @Update("update user set income = #{money} where name = #{username}")
        int upmoney(int money,String username);

        @Select("select id from user where name = #{name}")
        Integer getid(String name);

        @Select("select business_level from user where name = #{name}")
        Integer getlevel(String name);

        @Select("select status from user where name = #{name} ")
        int check(String name);

        @Select("select business_level from user where name = #{name} ")
        int level(String name);

        @Update("update user set income = #{income},point = #{point} where name = #{name}")
        int income(String name, Integer income, int point);
}

