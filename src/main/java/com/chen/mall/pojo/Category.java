package com.chen.mall.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Category {
    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;
}