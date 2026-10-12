package com.itheima.controller;

import com.itheima.anno.LogOperation;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.naming.factory.ResourceLinkFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级管理控制器
 */
@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //分页查询
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("查询请求参数：{}", clazzQueryParam);
        PageResult pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    //添加班级
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        clazzService.save(clazz);
        return Result.success();
    }

    //根据ID查询班级
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查询：{}",id);
        Clazz clazz = clazzService.selectById(id);
        return Result.success(clazz);
    }

    //修改班级
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级：{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    //根据ID删除班级
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("根据ID删除班级：{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    //查询所有班级
    @GetMapping("/list")
    public Result getAll(){
        List<Clazz> clazzList = clazzService.getAll();
        return Result.success(clazzList);
    }
}
