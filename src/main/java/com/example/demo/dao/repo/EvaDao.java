package com.example.demo.dao.repo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.EvaMapper;
import com.example.demo.dao.mapper.MoneyMapper;
import com.example.demo.dao.model.Eva;
import com.example.demo.dao.model.Money;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Repository
public class EvaDao extends ServiceImpl<EvaMapper, Eva> {





        @Resource
        private EvaMapper mapper;

        public int insert(Eva eva) {
            return mapper.insert(eva);
        }

        public List<Eva> search(Eva eva){
            return mapper.select(eva.getUserid());
        }


        public int upeva(Eva eva){
            return mapper.upeva(eva.getStar(),eva.getEva(),eva.getId());
        }

        public List<Eva> selectgoods(int goodsid){
            return mapper.selectgoods(goodsid);
        }


}
