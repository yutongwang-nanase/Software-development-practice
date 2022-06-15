package com.example.demo.server.controller;

import com.example.demo.dao.model.Shop;
import com.example.demo.server.service.impl.ShopServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopServicelmpl shopServicelmpl;

    @PostMapping("/search")
    public List<Shop> searchid(@RequestBody Shop shop) throws Exception{

        return shopServicelmpl.searchid(shop);
    }

    @PostMapping("/all")
    public List<Shop> selectall(@RequestBody Shop shop) throws Exception{

        return shopServicelmpl.searchall(shop);
    }

}
