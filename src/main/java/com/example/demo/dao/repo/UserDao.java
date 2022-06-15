package com.example.demo.dao.repo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.dao.model.User;
import com.example.demo.server.controller.dto.userDto;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDao extends ServiceImpl<UserMapper, User> {
    @Resource
    private UserMapper userMapper;

    public List<User> getAllData(){
        return userMapper.selectList(null);
    }

    public User getOneData(int id) {
        return userMapper.selectById(id);
    }

    public List<User> getCheckingData() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 0);

        return userMapper.selectList(wrapper);
    }


    public boolean login(userDto userdto) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",userdto.getUsername());
        queryWrapper.eq("password",userdto.getPassword());
        User one = getOne(queryWrapper);
        return one != null;
    }


//    public int logincheck(userDto userdto) {
//
//
//        return one != null;
//    }

    public int saveuser(String username, String password, String phonenum, String email, String city, String gender, String account, int type, Integer money, Integer businessLevel){
        User user=new User();
        user.setName(username);
        user.setPassword(password);
        user.setPhonenumber(phonenum);
        user.setEmail(email);
        user.setCity(city);
        user.setGender(Integer.valueOf(gender));
        user.setBanknumber(account);
        user.setType(type);
        user.setIncome(money);
        user.setStatus(0);
        user.setFavorableRate(Double.valueOf("0"));
        user.setPoint(0);
        user.setBusinessLevel(businessLevel);

        return userMapper.insert(user);
    }

    public int Check(int num,int point,String name){
        User user = new User();
        user.setName(name);
        user.setPoint(point);
        user.setIncome(num);
        return userMapper.updateById(user);
    }

    public List<User> findone(String username){
        List<User> data = userMapper.selectTotal(username);

        return data;
    }

    public int Chargeback(int money,String username,int point){


        int usermoney = findone(username).get(0).getIncome();
        int userpoint = findone(username).get(0).getPoint();
        System.out.println(usermoney);
        int newmoney = usermoney - money;
        System.out.println(newmoney);
        int newpoint = userpoint+point;

        return userMapper.upshop(newmoney,newpoint,username);
    }


    public int money(int money, String username) {
        int usermoney = findone(username).get(0).getIncome();
        int newmoney = usermoney + money;
        return userMapper.upmoney(newmoney,username);
    }


    public int updateuser(User user){
        return userMapper.updateById(user);
    }

    public int getid(String username){
        return userMapper.getid(username);
//        int userid = userMapper.selectTotal(username).get(0).getId();
//        return userid ;
    }

    public int getlevel(String name) {
        return userMapper.getlevel(name);
    }

    public int check(String name) {
        return userMapper.check(name);
    }

    public int level(String name) {
        return userMapper.level(name);
    }

    public int income(String name, Integer income) {
        int usermoney = findone(name).get(0).getIncome();
        int userpoint = findone(name).get(0).getPoint();
        int point = income/10000 + userpoint;
        income = usermoney - income;
        if (income < 0 ){
            return 0;
        }else return userMapper.income(name,income,point);
    }
}
