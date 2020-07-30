package kr.dataportal.cms.repository;

import kr.dataportal.cms.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPOL Select m from Member m where m.name = ?

    @Override
    Optional<Member> findByUsername(String username);
}
