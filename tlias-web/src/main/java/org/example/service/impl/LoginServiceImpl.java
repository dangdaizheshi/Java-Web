package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.pojo.LoginInfo;
import org.example.service.LoginService;
import org.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public LoginInfo login(Emp emp) {
        Emp e = empMapper.selectByUsernameAndPassword(emp);
        if(e != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", e.getId());
            data.put("username", e.getUsername());
            String token = JwtUtils.generateJwt(data);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), token);
        }
        else return null;
    }
}
