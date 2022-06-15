package com.example.demo.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.dao.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName(value = "user")

public class User extends BaseModel {


    @TableField(value = "name")
    private String name;

    @TableField(value = "password")
    private String password;

    @TableField(value = "avatar")
    private String avatar;

    @TableField(value = "phone_number")
    private String phonenumber;

    @TableField(value = "email")
    private String email;

    @TableField(value = "city")
    private String city;

    @TableField(value = "gender")
    private Integer gender;

    @TableField(value = "income")
    private Integer income;

    @TableField(value = "bank_number")
    private String banknumber;

    @TableField(value = "business_license")
    private String businessLicense;

    @TableField(value = "business_level")
    private Integer businessLevel;

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "favorable_rate")
    private Double favorableRate;

    @TableField(value = "point")
    private Integer point;
}
