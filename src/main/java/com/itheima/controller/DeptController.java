package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询部门列表");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /*
     * 根据ID删除部门数据 delete http://localhost:8080/depts?id=1
     */
    @DeleteMapping
    public Result delete(Integer id){
        // System.out.println("根据id删除部门，id=" + id);
        log.info("根据id删除部门，id：{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    /*
     *添加部门数据
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        // System.out.println("添加部门, dept=" + dept);
        log.info("新增部门，dept：{}",dept);
        deptService.insert(dept);
        return Result.success();
    }

    /*
     *根据ID查询部门数据
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        // System.out.println("根据ID查询，id=" + id);
        log.info("根据id查询，id：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /*
     * 修改部门 - put http://localhost:8080/depts
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        // System.out.println("修改部门，dept=" + dept);
        log.info("修改部门，dept：{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
