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
@TableName(value = "transaction")
public class Shop {

    @TableField(value = "id")
    private int id;

    @TableField(value = "time")
    private String time;

    @TableField(value = "payer")
    private String userid;

    @TableField(value = "point")
    private String point;

    @TableField(value = "money")
    private String money;

}
