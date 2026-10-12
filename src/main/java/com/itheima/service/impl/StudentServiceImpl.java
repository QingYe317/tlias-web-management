package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.*;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    /**
     * 分页查询
     */
    @Override
    public PageResult page(StudentQueryParam studentQueryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        //2. 执行查询
        List<Student> studentList = studentMapper.list(studentQueryParam);
        //3. 封装分页结果
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 添加学员
     * @param student
     */
    @Override
    public void save(Student student) {

        // 核心修复：无论前端传什么，统统强制设值
        if (student.getViolationCount() == null) {
            student.setViolationCount((short) 0);
        }
        if (student.getViolationScore() == null) {
            student.setViolationScore((short) 0);
        }

        // 填充时间
        LocalDateTime now = LocalDateTime.now();
        student.setCreateTime(now);
        student.setUpdateTime(now);

        studentMapper.save(student);
    }

    /**
     * 根据id查询学员
     * @param id
     * @return
     */
    @Override
    public Student selectById(Integer id) {
        Student student = studentMapper.selectById(id);
        return student;
    }

    /**
     * 修改学员
     * @param student
     */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    /**
     * 根据ids批量删除员工信息
     * @param ids
     */
    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /**
     * 违纪处理
     * @param id
     * @param score
     */
    @Override
    public void updateViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
}
