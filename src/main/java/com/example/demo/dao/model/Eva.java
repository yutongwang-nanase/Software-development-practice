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
@TableName(value = "evaluation")
public class Eva extends BaseModel{


        @TableField(value = "goodsid")
        private String goodsid;

        @TableField(value = "eva")
        private String eva;

        @TableField(value = "star")
        private int star;

        @TableField(value = "time")
        private String time;

        @TableField(value = "userid")
        private String userid;

        @TableField(value = "goodsname")
        private String goodsname;

        @TableField(value = "price")
        private String price;

        @TableField(value = "photo")
        private String photo;




}


