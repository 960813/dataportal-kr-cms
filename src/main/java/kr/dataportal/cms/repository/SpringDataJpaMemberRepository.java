package kr.dataportal.cms.repository;

import kr.dataportal.cms.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);

    Optional<Member> findById(long id);

    Optional<Member> findByUsername(String username);

    List<Member> findAll();
}
