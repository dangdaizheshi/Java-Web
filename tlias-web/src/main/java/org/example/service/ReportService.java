package org.example.service;

import org.example.pojo.GenderOption;
import org.example.pojo.JobOption;

import java.util.List;

public interface ReportService {

    JobOption getEmpJobData();

    List<GenderOption> getEmpGenderData();
}
