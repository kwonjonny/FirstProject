package com.hi.board.service;

import com.hi.board.domain.BoardDTO;
import com.hi.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Service
@Log4j2
public class BoardDeleteService {

    @Autowired
    private BoardMapper boardMapper;

    public int deleteBoard(int bno, HttpServletRequest request) {

        // 삭제 대상의 파일 이름을 획득
        BoardDTO board = boardMapper.selectByBno(bno);
        String deleteFileName = board.getFile1();

        // DB 삭제
        int result = boardMapper.deleteBoard(bno);
        // 파일 삭제
        if(deleteFileName != null) {
            // 웹경로
            String uri = "uploadfile/board";
            // 실제경로
            String realPath = request.getSession().getServletContext().getRealPath(uri);
            // 삭제 대상파일의 => File 객체
            File deleteFile = new File(uri, realPath);
            // 현재 File 이 존재하는지 여부 확인
            log.info("삭제 대상 파일 존재 유무 : " +deleteFile.exists());
            if(deleteFile.exists()) {
                // 삭제
                deleteFile.delete();
                log.info("첨부파일 삭제");
            }

            // 존재하면 삭제
        }

        return result;
    }
}
