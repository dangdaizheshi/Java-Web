package org.example.controller;

import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptlist = deptService.finaAll();
        return Result.success(deptlist);
    }
}
