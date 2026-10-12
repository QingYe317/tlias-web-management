package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.exception.BusinessException;
import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.*;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级管理
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询
     */
    @Override
    public PageResult page(ClazzQueryParam clazzQueryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        //3. 封装分页结果
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult(p.getTotal(), p.getResult());
    }

    /**
     * 添加班级
     */
    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    /**
     * 根据ID查询班级
     */
    @Override
    public Clazz selectById(Integer id) {
        Clazz clazz = clazzMapper.selectById(id);
        return clazz;
    }

    /**
     * 修改班级
     * @param clazz
     */
    @Override
    public void update(Clazz clazz) {
        // 强制设置修改时间
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /**
     * 根据ID删除班级
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        // 1. 判断该班级是否存在（可选，但推荐）
        Clazz clazz = clazzMapper.selectById(id);
        if (clazz == null) {
            throw new BusinessException("删除失败，该班级不存在");
        }

        // 2. 检查该班级下是否关联了学生
        int studentCount = studentMapper.countByClazzId(id);
        if (studentCount > 0) {
            // 如果数量大于0，抛出自定义业务异常
            throw new BusinessException("对不起, 该班级下有学生, 不能直接删除");
        }

        // 3. 确认无关联数据后，执行删除
        clazzMapper.deleteById(id);
    }

    /**
     * 查询所有班级
     * @return
     */
    @Override
    public List<Clazz> getAll() {
        List<Clazz> clazzList = clazzMapper.getAll();
        return clazzList;
    }
}
