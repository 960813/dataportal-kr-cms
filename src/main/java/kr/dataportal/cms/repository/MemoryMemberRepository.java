package kr.dataportal.cms.repository;

import kr.dataportal.cms.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // TODO: 2020-07-30 오후 1:46 sequence 증가 후 ID 지정, Map에 추가 -Jinssssun
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return store.values().stream()
                .filter(member -> member.getUsername().equals(username))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // TODO: 2020-07-30 오후 2:30 Test를 위한 store 초기화 메소드 추가 -Jinssssun
    public void clearStore() {
        store.clear();
    }
}
