package kr.dataportal.cms.repository;

import kr.dataportal.cms.domain.Board;
import kr.dataportal.cms.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaBoardRepository extends JpaRepository<Board, Long> {

}
