package com.example.demo.server.service.impl;

import com.example.demo.dao.model.User;
import com.example.demo.dao.repo.UserDao;
import com.example.demo.server.controller.dto.userDto;
import com.example.demo.server.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllData() {
        return userDao.getAllData();
    }

    @Override
    public User getOneData(int id) {
        return userDao.getOneData(id);
    }

    @Override
    public List<User> getCheckingData() {
        return userDao.getCheckingData();
    }

    @Override
    public boolean login(userDto userdto) {
        return userDao.login(userdto);
    }

//    @Override
//    public boolean logincheck(User user) {
//        return userDao.login(user);
//    }

    @Override
    public int saveuser(User user) {
        return userDao.saveuser(user.getName(),user.getPassword(),user.getPhonenumber(),user.getEmail(),user.getCity(), String.valueOf(user.getGender()),user.getBanknumber(),user.getType(),user.getIncome(),user.getBusinessLevel());
    }

    @Override
    public int Changeback(User user) {

        return   userDao.Chargeback(user.getIncome(),user.getName(),user.getPoint());
    }

    @Override
    public List<User> Findone(User user) {
        return userDao.findone(user.getName());
    }

    @Override
    public int money(User user) {

        return userDao.money(user.getIncome(),user.getName());
    }

    @Override
    public int updateuser(User user) {
        return userDao.updateuser(user);
    }

    @Override
    public int getid(String username) {
        return userDao.getid(username);
    }

    @Override
    public int getlevel(String name) {
        return userDao.getlevel(name);
    }

    @Override
    public int check(String name) {
        return userDao.check(name);
    }

    @Override
    public int level(String name) {
        return userDao.level(name);
    }

    @Override
    public int income(String name, Integer income ) {
        return userDao.income(name,income);
    }
}
