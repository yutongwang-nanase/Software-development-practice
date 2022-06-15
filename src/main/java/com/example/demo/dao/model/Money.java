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
@TableName(value = "money")
public class Money extends BaseModel {

//    @TableField(value = "id")
//    private int id;

    @TableField(value = "user_name")
    private String username;

    @TableField(value = "money")
    private int money;

    @TableField(value = "point")
    private int point;

    @TableField(value = "created_at")
    private String time;

    @TableField(value = "is_pay")
    private int ispay;


}