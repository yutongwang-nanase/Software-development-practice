package com.example.demo.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.dao.base.BaseModel;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName(value = "product")
public class Goods extends BaseModel {

//    @TableField(value = "id")
//    private int id;

    @TableField(value = "product_name")
    private String productName;

    @TableField(value = "publisher_name")
    private String publishername;


    @TableField(value = "product_image")
    private String productimage;

    @TableField(value = "product_price")
    private int productprice;

    @TableField(value = "product_instruction")
    private String productinstruction;

    @TableField(value = "product_type")
    private String producttype;

    @TableField(value = "product_discount")
    private int productdiscount;

    @TableField(value = "bargaining_allowed")
    private int bargainingallowed;

    @TableField(value = "wear_degree")
    private String weardegree;

    @TableField(value = "product_stock")
    private int productstock;

    @TableField(value = "purchase_number")
    private int purchasenumber;

    @TableField(value = "status")
    private int status;


    private int pageNum;

    private int pageSize;


}
