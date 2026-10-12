package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    /**
     * 分页查询
     * @param clazzQueryParam
     */
    PageResult page(ClazzQueryParam clazzQueryParam);

    /**
     * 添加班级
     * @param clazz
     */
    void save(Clazz clazz);


    /** 根据ID查询班级
     * @param id
     * @return
     */
    Clazz selectById(Integer id);

    /**
     * 修改班级
     * @param clazz
     */
    void update(Clazz clazz);

    /**
     * 根据ID删除班级
     * @param id
     */
    void deleteById(Integer id);
    /**
     * 查询所有班级
     */
    List<Clazz> getAll();
}
