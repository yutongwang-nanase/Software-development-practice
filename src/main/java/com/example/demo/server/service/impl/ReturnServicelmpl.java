package com.example.demo.server.service.impl;

import com.example.demo.dao.model.ReturnRequest;
import com.example.demo.dao.repo.ReturnDao;
import com.example.demo.server.service.IReturnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReturnServicelmpl implements IReturnService {
    @Autowired
    ReturnDao returnDao;


    @Override
    public int insert(ReturnRequest re) {
        return returnDao.insert(re);
    }
}
