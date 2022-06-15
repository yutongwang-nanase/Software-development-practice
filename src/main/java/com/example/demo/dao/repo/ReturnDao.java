package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.MoneyMapper;
import com.example.demo.dao.mapper.ReturnMapper;
import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.ReturnRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class ReturnDao extends ServiceImpl<ReturnMapper, ReturnRequest> {

    @Resource
    private ReturnMapper mapper;

    public int insert(ReturnRequest re) {
        return mapper.insert(re);
    }

}