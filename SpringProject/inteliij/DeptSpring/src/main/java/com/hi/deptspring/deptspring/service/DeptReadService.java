package com.hi.deptspring.deptspring.service;

import com.hi.deptspring.deptspring.domain.DeptDTO;
import com.hi.deptspring.deptspring.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptReadService {

    private DeptMapper deptMapper;

    @Autowired
    public DeptReadService(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public DeptDTO getDept(int deptno) {
        return deptMapper.selectByDeptno(deptno);
    }

}
