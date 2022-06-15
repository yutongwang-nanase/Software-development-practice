package com.example.demo.server.controller;

import cn.hutool.core.util.StrUtil;
import com.example.demo.dao.model.User;
import com.example.demo.server.controller.dto.userDto;
import com.example.demo.server.domain.http.ResultData;
import com.example.demo.server.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/get")
    public ResultData getAllData() throws Exception {
        List<User> userList = userService.getAllData();
        if (userList == null) {
            throw new Exception("未获取到数据");
        }
        if (userList.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(userList);
    }

    @PostMapping("/getCheckingData")
    public ResultData getCheckingData() throws Exception {
        List<User> userList = userService.getCheckingData();
        if (userList == null) {
            throw new Exception("未获取到数据");
        }
        return ResultData.success(userList);
    }

    @PostMapping ("/login")
    public boolean login(@RequestBody userDto userdto){
        String username = userdto.getUsername();
        String password = userdto.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return false;
        }
        return userService.login(userdto);
    }

//    @PostMapping ("/logincheck")
//    public boolean logincheck (@RequestBody User user){
//
//
//        return userService.login(userdto);
//    }


    @PostMapping
    public int saveuser(@RequestBody User user) {
        String username = user.getName();
//        if (){
//            return ResultData.failure("....");
//        }
        log.info(String.valueOf(user));
        return userService.saveuser(user);
    }

    @PostMapping("/changeback")
    public int Changeback(@RequestBody User user) {
        return userService.Changeback(user);
    }


    @PostMapping("/findone")
    public List<User> Findone(@RequestBody User user){
        return userService.Findone(user);
    }

    @PostMapping("/money")
    public int money(@RequestBody User user){
        return userService.money(user);
    }

    @PostMapping("/updateuser")
    public int updateuser(@RequestBody User user){
        return userService.updateuser(user);
    }

    @PostMapping("/getid")
    public int getid(@RequestBody User user){
        return userService.getid(user.getName());
    }

    @PostMapping("/getlevel")
    public int getlevel(@RequestBody User user){
        return userService.getlevel(user.getName());
    }

    @PostMapping("/check")
    public int check(@RequestBody User user){
        return userService.check(user.getName());
    }

    @PostMapping("/level")
    public int level(@RequestBody User user){
        return userService.level(user.getName());
    }

    @PostMapping("/income")
    public int income(@RequestBody User user){
        return userService.income(user.getName(),user.getIncome());
    }

}
