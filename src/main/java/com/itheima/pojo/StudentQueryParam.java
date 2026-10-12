package com.itheima.pojo;

import lombok.Data;

@Data
public class StudentQueryParam {

    private String name; //姓名
    private Integer degree; //学历
    private Integer clazzId; //班级id
    private Integer page = 1; //分页查询的页码
    private Integer pageSize = 10; //每页记录数

}
