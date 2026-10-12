package com.itheima.service;

import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    /**
     * 分页查询
     * @param studentQueryParam
     */
    PageResult page(StudentQueryParam studentQueryParam);

    /**
     * 添加学员
     * @param student
     */
    void save(Student student);

    /**
     * 根据id查询学员
     * @param id
     * @return
     */
    Student selectById(Integer id);

    /**
     * 修改学员
     * @param student
     */
    void update(Student student);

    /**
     * 根据ids批量删除学员信息
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 违纪处理
     * @param id
     * @param score
     */
    void updateViolation(Integer id, Integer score);
}
