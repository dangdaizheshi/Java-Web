package org.example.service.impl;

import org.example.mapper.DeptMapper;
import org.example.pojo.Dept;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> finaAll() {
        return deptMapper.finaAll();
    }

    @Override
    public void delete(List<Integer> ids) {
        deptMapper.deleteByDeptIds(ids);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept selectDeptById(Integer id) {
        return deptMapper.selectDeptById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
