package com.example.demo.server.controller;


import com.example.demo.dao.model.Money;
import com.example.demo.dao.model.Transaction;
import com.example.demo.server.service.impl.TranServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/tran")
public class TranController {

    @Autowired
    private TranServicelmpl tranServicelmpl;

    @PostMapping
    public int add(@RequestBody Transaction tran){
        return tranServicelmpl.add(tran);
    }

    @PostMapping("/search")
    public List<Transaction> search(@RequestBody Transaction tran){
        return tranServicelmpl.search(tran);
    }

    @PostMapping("/delete")
    public int delete(@RequestBody Transaction tran){
        return tranServicelmpl.delete(tran);
    }

    @PostMapping("/check")
    public int check(@RequestBody Transaction tran){
        return tranServicelmpl.check(tran);
    }

    @PostMapping("/money")
    public int money(@RequestBody Transaction tran){
        return tranServicelmpl.money(tran);
    }

    @PostMapping("/all")
    public List<Transaction> commit(@RequestBody Transaction tran){
        return tranServicelmpl.commit(tran);
    }

    @PostMapping("/all2")
    public List<Transaction> commit2(@RequestBody Transaction tran){
        return tranServicelmpl.commit2(tran);
    }

    @PostMapping("/enough")
    public int enough() throws InterruptedException {
        Thread.currentThread().sleep(1000);
        return tranServicelmpl.enough();
    }
    @PostMapping("/enough1")
    public List<Money> enough1() throws InterruptedException {

        return tranServicelmpl.enough1();
    }


    @PostMapping("/demoney")
    public int demoney(){
        return tranServicelmpl.demoney();
    }

}
