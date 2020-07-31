package kr.dataportal.cms.service;

import kr.dataportal.cms.repository.SpringDataJpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BoardService {
    private final SpringDataJpaBoardRepository springDataJpaBoardRepository;

    @Autowired
    public BoardService(SpringDataJpaBoardRepository springDataJpaBoardRepository) {
        this.springDataJpaBoardRepository = springDataJpaBoardRepository;
    }


}
