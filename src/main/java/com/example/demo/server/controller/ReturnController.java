package com.example.demo.server.controller;

import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.ReturnRequest;
import com.example.demo.server.service.IReturnService;
import com.example.demo.server.service.impl.IMoneyServicelmpl;
import com.example.demo.server.service.impl.ReturnServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/return")
public class ReturnController {

    @Autowired
    ReturnServicelmpl returnServicelmpl;


    @PostMapping
    public int insert(@RequestBody ReturnRequest re){
        return returnServicelmpl.insert(re);
    }


}
