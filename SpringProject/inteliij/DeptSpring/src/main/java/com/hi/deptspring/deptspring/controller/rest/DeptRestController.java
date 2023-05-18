package com.hi.deptspring.deptspring.controller.rest;

import com.hi.deptspring.deptspring.domain.DeptDTO;
import com.hi.deptspring.deptspring.domain.DeptRegistRequest;
import com.hi.deptspring.deptspring.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// v2 유저정보받아주는
@Log4j2
@RestController
@RequestMapping("/api/v1/depts")
public class DeptRestController {

    // get 전체 리스트
    // get /{no} : 부서 하나의 정보를 반환
    // post : JSON Type 형식의 데이터를 받아서 데이터 베이스에 저장
    // put /{no} : 하나의 부서 정보를 수정, 전체 데이터를 수정해주는것
    // delete /{no} : 부서 정보 하나를 삭제

    private final DeptListService deptListService;
    private final DeptReadService deptReadService;
    private final DeptRegistService deptRegistService;
    private final DeptModfiyService deptModfiyService;
    private final DeptDeleteService deptDeleteService;

    @Autowired
    public DeptRestController(DeptListService deptListService,
                              DeptReadService deptReadService,
                              DeptRegistService deptRegistService,
                              DeptModfiyService deptModfiyService,
                              DeptDeleteService deptDeleteService) {
        this.deptListService = deptListService;
        this.deptReadService = deptReadService;
        this.deptRegistService = deptRegistService;
        this.deptModfiyService = deptModfiyService;
        this.deptDeleteService = deptDeleteService;
    }

    @GetMapping // /api/v1/depts
    public ResponseEntity<List<DeptDTO>> getDeptList() {

        // ResponseEntity<T> -> 응답 데이터를 generic 으로 정의
        // body(응답 데이터), httpHeader , statusCode , s
        // Header 정의 -> httpHeaders
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header" , "some-value");
        ResponseEntity<List<DeptDTO>> entity = new ResponseEntity<>(deptListService.getList(), httpHeaders, HttpStatus.OK);

        return entity;
    }

    @GetMapping("/{no}")
    public ResponseEntity<DeptDTO> getDept(@PathVariable("{no}") int deptno) {

        ResponseEntity<DeptDTO> entity = new ResponseEntity<>(deptReadService.getDept(deptno), HttpStatus.OK);

        return entity;
    }

    @PostMapping    // /api/v1/depts
    public ResponseEntity<String> regDept(@RequestBody DeptRegistRequest registRequest) {
        // JSON 데이터를 JAVA 객체로 받아야한다
        log.info("JSON -> DeptRegistRequest : "+registRequest);
        int result = deptRegistService.registDept(registRequest);

        return new ResponseEntity<>("insert " + (result==1?"OK":"FAIL"), HttpStatus.OK);
    }

    @PutMapping("/{no}")
    public ResponseEntity<String> edit(@PathVariable("no") int deptno , @RequestBody DeptDTO dept) {
        // JSON 데이터를 JAVA 객체로 받아야한다
        log.info("JSON -> DeptDTO : " + dept);
        int result = deptModfiyService.modfiyDept(dept);
        String msg = "update " + (result == 1? "OK" : "FAIL");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> delete(@PathVariable("no") int deptno) {
        log.info("JSON -> deptno : "+ deptno);
        int result = deptDeleteService.deleteDept(deptno);
        String msg = "DELETE " + (result == 1? "OK" : "FALSE");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
