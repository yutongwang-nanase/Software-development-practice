package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.model.Transaction;
import com.example.demo.dao.model.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TranMapper extends BaseMapper<Transaction> {

    @Select("select * from transaction WHERE payer = #{username} and is_pay = 1 and is_receive = 0 ")
    List<Transaction> selectTotal(String username);

    @Select("select * from transaction WHERE payer = #{username} and is_pay = 1 and is_receive = 1 ")
    List<Transaction> selectTotal2(String username);

    @Select("select * from transaction WHERE payer = #{username} AND is_pay = 0 ")
    List<Transaction> search(String username);

    @Update("UPDATE transaction SET is_pay = 1 WHERE payer = #{payer}")
    int check(String payer);

//    @Update("UPDATE transaction SET is_pay = 1 WHERE payer = #{payer}")
//    int check(String payer);

//    @Select("select * from transaction WHERE payer = #{username} AND is_pay = 1 ")
//    List<Transaction> commit(String username);
}
