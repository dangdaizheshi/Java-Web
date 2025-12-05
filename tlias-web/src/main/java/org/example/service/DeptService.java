package org.example.service;

import org.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> finaAll();

    void delete(List<Integer> ids);

    void addDept(Dept dept);

    Dept selectDeptById(Integer id);

    void update(Dept dept);
}
