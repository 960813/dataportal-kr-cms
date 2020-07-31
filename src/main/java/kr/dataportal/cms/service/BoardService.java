package kr.dataportal.cms.service;

import kr.dataportal.cms.domain.Board;
import kr.dataportal.cms.repository.SpringDataJpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class BoardService {
    private final SpringDataJpaBoardRepository boardRepository;

    @Autowired
    public BoardService(SpringDataJpaBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long savePost(Board board) {
        return boardRepository.save(board).getId();
    }

    public List<Board> findAllPosts() {
        return boardRepository.findAll();
    }
}
