package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.pojo.LoginInfo;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public LoginInfo login(Emp emp) {
        Emp e = empMapper.selectByUsernameAndPassword(emp);
        if(e != null) return new LoginInfo(e.getId(), e.getUsername(), e.getName(), "123456");
        else return null;
    }
}
