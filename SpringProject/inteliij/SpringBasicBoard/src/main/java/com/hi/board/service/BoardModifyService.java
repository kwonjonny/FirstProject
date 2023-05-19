package com.hi.board.service;

import com.hi.board.domain.RequestModifyRequest;
import com.hi.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Log4j2
public class BoardModifyService {

    @Autowired
    private BoardMapper boardMapper;

    public int modifyBoardDTO(RequestModifyRequest modifyRequest
        , HttpServletRequest request) {

        // 파일 저장 : 파일이 존재하면 저장
        if (modifyRequest.getFile1() != null && modifyRequest.getFile1().getSize() > 0) {

            // 웹 경로
            String uri = "/uploadfile/board";

            // 실제경로
            String realPath = request.getSession().getServletContext().getRealPath(uri);

            // 새로운 파일 이름 생성
            String newFilename = UUID.randomUUID().toString()+modifyRequest.getFile1().getOriginalFilename();

            // 저장
            File newFile = new File(realPath, newFilename);

            // filename 속성에 새로운 파일 이름을 저장
            try {
                modifyRequest.getFile1().transferTo(newFile);

                modifyRequest.setFilename(newFilename);
            } catch (IOException e) {
                // throw new RuntimeException(e);
                // filename oldfile이 가지고있는 파일 이름 설정
                modifyRequest.setFilename(modifyRequest.getOldfile());
                throw new RuntimeException(e);
            }

        } else {
            // filename 속성에 이전 업로드 되어있는 파일 이름 저장
            modifyRequest.setFilename(modifyRequest.getOldfile());
        }
        // mapper.update
        log.info(modifyRequest);

    return  boardMapper.updateBoard(modifyRequest);
    }

}
