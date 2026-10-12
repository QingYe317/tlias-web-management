package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生管理控制器
 */
@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //分页查询
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("查询请求参数：{}", studentQueryParam);
        PageResult pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    //添加学员
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("添加学员：",student);
        studentService.save(student);
        return Result.success();
    }

    //根据id查询学员
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Student student = studentService.selectById(id);
        return Result.success(student);
    }

    //修改学员
    @PutMapping
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }

    //删除员工(批量)
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){
        studentService.deleteByIds(ids);
        return Result.success();
    }

    //违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id,@PathVariable Integer score){
        studentService.updateViolation(id, score);
        return Result.success();
    }
}
