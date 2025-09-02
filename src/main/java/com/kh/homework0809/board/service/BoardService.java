package com.kh.homework0809.board.service;

import com.kh.homework0809.board.dto.*;
import com.kh.homework0809.board.entity.BoardEntity;
import com.kh.homework0809.board.repository.BoardRepository;
import com.kh.homework0809.common.Authenticator;
import com.kh.homework0809.employee.repository.EmpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;
    private final EmpRepository empRepository;

    public RespBoardList lookUp() {
        var result = repository.lookUp();

        if (result.isEmpty()) {
            return RespBoardList.builder()
                    .msg("조회된 게시글이 없습니다.")
                    .data(null)
                    .build();
        }

        return RespBoardList.from(result);
    }

    public RespBoardList lookUpMine(int no) {
        var result = repository.lookUpMine(no);

        if (result.isEmpty()) {
            return RespBoardList.builder()
                    .msg("조회된 게시글이 없습니다.")
                    .data(null)
                    .build();
        }

        return RespBoardList.from(result);
    }

    public RespBoard lookAt(int bno) {

        var result = repository.lookAt(bno);

        if (result == null) {
            return RespBoard.builder()
                    .msg("조회된 게시글이 없습니다.")
                    .data(null)
                    .build();
        }
        result.increaseView();

        return RespBoard.from(result);
    }

    public RespModifyBoard modifyBoard(ReqModifyBoard dto, Authenticator auth) {
        var entity = repository.lookAt(dto.getTargetNo());

        if(entity.getWriter().getEno() != auth.getNo()){
            return RespModifyBoard.builder()
                    .msg("본인이 작성한 글만 수정할 수 있습니다.")
                    .data(null)
                    .build();
        }

        if (entity == null) {
            return RespModifyBoard.builder()
                    .msg("수정할 게시글이 없습니다.")
                    .data(null)
                    .build();
        }

        entity.modifyBoard(dto);

        return RespModifyBoard.from(entity);
    }

    public RespDeleteBoard deleteBoard(int bno, Authenticator auth) {
        var entity = repository.lookAt(bno);

        if (auth == null || entity.getWriter().getEno() != auth.getNo()) {
            return RespDeleteBoard.builder()
                    .msg("본인이 작성한 글만 삭제할 수 있습니다.")
                    .data(null)
                    .build();
        }

        if (entity == null) {
            return RespDeleteBoard.builder()
                    .msg("삭제할 게시글이 없습니다.")
                    .data(null)
                    .build();
        }

        entity.delete(entity);

        return RespDeleteBoard.from(entity);
    }

    public RespWriteBoard writeBoard(ReqWriteBoard dto) {
        var writer = empRepository.findByNo(dto.getWriterNo());
        var newBoard = BoardEntity.from(dto, writer);

        repository.write(newBoard);

        return RespWriteBoard.from(newBoard);
    }
}
