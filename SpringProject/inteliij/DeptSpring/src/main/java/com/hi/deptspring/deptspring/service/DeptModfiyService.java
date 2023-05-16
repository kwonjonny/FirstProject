package com.hi.deptspring.deptspring.service;

import com.hi.deptspring.deptspring.domain.DeptDTO;
import com.hi.deptspring.deptspring.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptModfiyService {

    private final DeptMapper deptMapper;

    @Autowired
    public DeptModfiyService(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public int modfiyDept(DeptDTO dto) {
        return deptMapper.updateDept(dto);
    }

}
