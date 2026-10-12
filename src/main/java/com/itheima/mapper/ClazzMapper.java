package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 查询班级及开班状态
     */
    public List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 添加班级
     */
    void save(@Param("clazz") Clazz clazz);

    /**
     * 根据ID查询班级
     */
    Clazz selectById(Integer id);

    /**
     * 修改班级
     * @param clazz
     */
    void update(@Param("clazz") Clazz clazz);

    /**
     * 根据ID删除班级
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询所有班级
     * @return
     */
    List<Clazz> getAll();
}


