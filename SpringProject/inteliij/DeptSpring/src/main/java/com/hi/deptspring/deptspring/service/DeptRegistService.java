package com.hi.deptspring.deptspring.service;

import com.hi.deptspring.deptspring.domain.DeptRegistRequest;
import com.hi.deptspring.deptspring.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptRegistService {

    private DeptMapper mapper;

    @Autowired
    public DeptRegistService(DeptMapper mapper) {
        this.mapper =mapper;
    }

    public int registDept(DeptRegistRequest registRequest) {
        
        return mapper.insertDept(registRequest);
    }


}
