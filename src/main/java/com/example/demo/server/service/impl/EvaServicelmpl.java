package com.example.demo.server.service.impl;

import com.example.demo.dao.model.Eva;
import com.example.demo.dao.repo.EvaDao;
import com.example.demo.server.service.IEvaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EvaServicelmpl implements IEvaService {


    @Autowired
    EvaDao evaDao;


    @Override
    public void insert(ArrayList<Eva> eva) {
        for(int i =0;i<eva.size();i++){
                Eva insert = eva.get(i);
                    log.info(String.valueOf(insert));
                    evaDao.insert(insert);
            }

    }

    @Override
    public List<Eva> search(Eva eva){
        return evaDao.search(eva);
    }

    @Override
    public int upeva(Eva eva){
        return evaDao.upeva(eva);
    }

    @Override
    public List<Eva> selectgood(Eva eva){

        return evaDao.selectgoods(Integer.parseInt(eva.getGoodsid()));
    }


}