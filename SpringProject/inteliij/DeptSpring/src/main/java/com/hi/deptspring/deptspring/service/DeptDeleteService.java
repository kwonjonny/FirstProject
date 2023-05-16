package com.hi.deptspring.deptspring.service;

import com.hi.deptspring.deptspring.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptDeleteService {

    private final DeptMapper deptMapper;

    @Autowired
    public DeptDeleteService(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public int deleteDept(int deptno) {
        return deptMapper.deleteDept(deptno);
    }
    
}
