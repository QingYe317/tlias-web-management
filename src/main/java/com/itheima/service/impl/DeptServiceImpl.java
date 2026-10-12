package com.itheima.service.impl;

import com.itheima.anno.LogOperation;
import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    @LogOperation //自定义注解（表示：当前方法属于目标方法）
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    @Override
    @LogOperation //自定义注解（表示：当前方法属于目标方法）
    public void deleteById(Integer id){
        deptMapper.deleteById(id);
    }


    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }


    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

}
