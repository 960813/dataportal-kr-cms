package kr.dataportal.cms.repository;

import kr.dataportal.cms.domain.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

// TODO: 2020-07-30 오후 1:43 MemberRepository 생성 -Jinssssun
public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(long id);

    Optional<Member> findByAuthId(String authId);

    Optional<Member> findByUsername(String username);

    List<Member> findAll();
}
