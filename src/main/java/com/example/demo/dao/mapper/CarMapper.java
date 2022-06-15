package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.base.BaseModel;
import com.example.demo.dao.model.Car;
import com.example.demo.server.domain.http.ResultData;
import org.apache.ibatis.annotations.Delete;

public interface CarMapper extends BaseMapper<Car> {

    @Delete("delete from car where user_id = #{userid}")
    int deletebyname(String userid);
}
