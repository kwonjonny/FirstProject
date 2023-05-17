package com.hi.deptspring.deptspring.controller.rest;


import com.hi.deptspring.deptspring.domain.DeptDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class ExampleRestController {

    // 메소드의 반환 타입이 String 이면 문자열 응답이다
    @GetMapping("/sample1")
    public String hello() {
        return "Hello"; // /WEB-INF/views/Hello.jsp
    }


    @GetMapping("/sample2")
    public DeptDTO getDept() {

        DeptDTO dept = DeptDTO.builder()
                .deptno(91)
                .dname("DEV")
                .loc("pyeongYang")
                .build();
        return dept;
    }


    @GetMapping("/sample3")
    public List<DeptDTO> getDeptList() {
        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10,"TEST1" , "LOC1"));
        list.add(new DeptDTO(10,"TEST1" , "LOC1"));
        list.add(new DeptDTO(10,"TEST1" , "LOC1"));
        list.add(new DeptDTO(10,"TEST1" , "LOC1"));
        list.add(new DeptDTO(10,"TEST1" , "LOC1"));
        return list;
    }

    @GetMapping("/sample4")
    public Map<Integer, DeptDTO> getDeptMap() {
        Map<Integer, DeptDTO> map = new HashMap<>();
        map.put(10 , new DeptDTO(10,"TEST2","LOC1"));
        map.put(11 , new DeptDTO(12,"TEST3","LOC2"));
        map.put(12 , new DeptDTO(13,"TEST4","LOC3"));
        map.put(13 , new DeptDTO(14,"TEST5","LOC4"));
        map.put(14 , new DeptDTO(15,"TEST6","LOC15"));
        return map;
    }
}
