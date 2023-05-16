package com.hi.deptspring;

import com.hi.deptspring.deptspring.domain.DeptDTO;
import com.hi.deptspring.deptspring.mapper.DeptMapper;
import com.hi.deptspring.deptspring.mapper.TimeMapper;
//import com.hi.deptspring.deptspring.mapper.TimeMapper2;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private TimeMapper timeMapper;

//    @Autowired(required = false)
//    private TimeMapper2 timeMapper2;

    @Autowired(required = false)
    private DeptMapper deptMapper;


    @Test
    public void getDeptList() {
        List<DeptDTO> list = deptMapper.selectByAll();
        log.info(">>>>" + list);
        log.info(deptMapper.selectByDeptno(10));
        log.info(deptMapper.selectByDeptno(20));
        log.info(deptMapper.selectByDeptno(30));
        log.info(deptMapper.selectByDeptno(40));
    }

    @Test
    public void getTimeMapperTest() {
        // TimeMapper 구현체 주입 여부 확인 , 메소드 실행 결과
        log.info(timeMapper.getTime());
//        log.info(timeMapper2.getTime());
    }

    @Test
    public void testConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection + "========================================================");
        Assertions.assertNotNull(connection);
        connection.close();
    }

}
