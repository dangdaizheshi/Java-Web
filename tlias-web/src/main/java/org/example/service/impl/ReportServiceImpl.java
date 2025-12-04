package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.pojo.GenderOption;
import org.example.pojo.JobOption;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        // 将 list 集合中每个 Map 的键(Object类型)封装到 JobOption 的 jobList 中，值(Object类型)封装到 JobOption 的 dataList 中
        List<Object> jobList = list.stream().map(map -> map.get("pos")).toList();
        List<Object> dataList = list.stream().map(map -> map.get("number")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<GenderOption> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
