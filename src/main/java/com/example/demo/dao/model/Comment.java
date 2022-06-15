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
@TableName(value = "comment")
//评论
public class Comment extends BaseModel {
    @TableField(value = "user_id")
    private long userId;

    @TableField(value = "product_id")
    private Integer productId;

    @TableField(value = "comment")
    private String comment;

    @TableField(value = "type")
    private Integer type;
}
