package com.hi.board;

import com.hi.board.domain.BoardDTO;
import com.hi.board.domain.RequestRegBoard;
import com.hi.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionTest {

    private final DataSource dataSource;
    private final BoardMapper boardMapper;

    @Autowired(required = false)
    public ConnectionTest(DataSource dataSource, BoardMapper boardMapper) {
        this.dataSource = dataSource;
        this.boardMapper = boardMapper;
    }

    @Test
    public void deptListTest() {
        List<BoardDTO> list = boardMapper.selectAll();
        log.info(list);
    }

    @Test
    public void boardInsertTest() {
        RequestRegBoard requestRegBoard = RequestRegBoard.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .writer("테스트 쓰기")
                .build();

        log.info("requestBoard " + requestRegBoard);
        boardMapper.insertBoard(requestRegBoard);
    }

    @Test
    public void mapperTest() {
        Assertions.assertNotNull(boardMapper);
    }

    @Test
    public void connectionTest() throws SQLException {
        Connection connection = dataSource.getConnection();

        log.info("connection => " + connection);
        connection.close();
    }

}
