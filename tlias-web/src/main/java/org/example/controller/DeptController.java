package org.example.controller;

import org.example.anno.Log;
import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @GetMapping()
    public Result list() {
        List<Dept> deptlist = deptService.finaAll();
        return Result.success(deptlist);
    }

    @Log
    @DeleteMapping()
    public Result delete(@RequestParam List<Integer> ids) {
        deptService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result addDept(@RequestBody Dept dept) {
        deptService.addDept(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        Dept dept = deptService.selectDeptById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping()
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }
}