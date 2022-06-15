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
@TableName(value = "car")
public class Car extends BaseModel {

//    @TableField(value = "id")
//    private int id;

    @TableField(value = "product_id")
    private String goodsid;

    @TableField(value = "user_id")
    private String userid;

    @TableField(value = "purchase_num")
    private int num;

    @TableField(value = "price")
    private String price;

    @TableField(value = "product_name")
    private String goodsname;

    @TableField(value = "product_image")
    private String photo;

    @TableField(value = "purchase_name")
    private String purchasename;

}