package com.example.demo.server.controller;

import com.example.demo.dao.model.Eva;
import com.example.demo.dao.model.Money;
import com.example.demo.server.service.IEvaService;
import com.example.demo.server.service.impl.EvaServicelmpl;
import com.example.demo.server.service.impl.IMoneyServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/eva")
public class EvaController {


        @Autowired
        private EvaServicelmpl evaServicelmpl;


        @PostMapping("/insert")
        public void insertdata(@RequestBody ArrayList<Eva> eva){
            evaServicelmpl.insert(eva);
        }

        @PostMapping("/up")
        public int up(@RequestBody Eva eva){
                return evaServicelmpl.upeva(eva);
        }

        @PostMapping("/search")
        public List<Eva> search(@RequestBody Eva eva){
                return evaServicelmpl.search(eva);
        }

        @PostMapping("/goods")
        public List<Eva> goods(@RequestBody Eva eva){
                return evaServicelmpl.selectgood(eva);
        }

}
