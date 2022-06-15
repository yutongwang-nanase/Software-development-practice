package com.example.demo.server.service;

import com.example.demo.dao.model.User;
import com.example.demo.server.controller.dto.userDto;

import java.util.List;

public interface IUserService {
        List<User> getAllData();
        User getOneData(int id);
        List<User> getCheckingData();
        boolean login(userDto userdto);

//
//    boolean logincheck(User user);

    int saveuser(User user);

        int Changeback(User user);

    List<User> Findone(User user);

    int money(User user);

    int updateuser(User user);



    int getid(String id);

    int getlevel(String name);

    int check(String name);

    int level(String name);

    int income(String name, Integer income);
}
