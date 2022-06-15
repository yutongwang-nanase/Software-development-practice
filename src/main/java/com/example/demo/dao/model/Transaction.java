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
//交易表
public class Transaction extends BaseModel {
    @TableField(value = "product_name")
    private String productName;

    @TableField(value = "payer")
    private String payer;

    @TableField(value = "payee")
    private String payee;

    @TableField(value = "money")
    private Integer money;

    @TableField(value = "business_level")
    private Integer businessLevel;

    @TableField(value = "is_receive")
    private Integer isreceive;

    @TableField(value = "is_pay")
    private Integer ispay;

    @TableField(value = "product_id")
    private Integer productid;

    @TableField(value = "user_id")
    private Integer userid;
}
