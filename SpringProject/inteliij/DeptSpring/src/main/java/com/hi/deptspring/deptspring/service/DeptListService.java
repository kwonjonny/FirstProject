package com.hi.deptspring.deptspring.service;

import com.hi.deptspring.deptspring.domain.DeptDTO;
import com.hi.deptspring.deptspring.mapper.DeptMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class DeptListService {


    private final DeptMapper mapper;

    @Autowired
    public DeptListService(DeptMapper mapper) {
        this.mapper = mapper;
    }


    public List<DeptDTO> getList() {
        return mapper.selectByAll();
    }

}
