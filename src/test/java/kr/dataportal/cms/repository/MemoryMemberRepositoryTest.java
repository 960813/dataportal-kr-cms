package kr.dataportal.cms.repository;

import kr.dataportal.cms.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setDisplayName("Jin TaeYang");
        member.setUserName("taeyang");
        member.setPasswordHash(member.getUserName() + "password");
        member.setPasswordSalt(member.getUserName() + "salt");
        member.setAuthId("local:" + member.getUserName());

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByAuthId() {
        Member member1 = new Member();
        member1.setDisplayName("Jin TaeYang");
        member1.setUserName("taeyang");
        member1.setPasswordHash(member1.getUserName() + "password");
        member1.setPasswordSalt(member1.getUserName() + "salt");
        member1.setAuthId("local:" + member1.getUserName());
        repository.save(member1);

        Member member2 = new Member();
        member2.setDisplayName("Spring Framework");
        member2.setUserName("spring");
        member2.setPasswordHash(member2.getUserName() + "password");
        member2.setPasswordSalt(member2.getUserName() + "salt");
        member2.setAuthId("local:" + member2.getUserName());
        repository.save(member2);

        Member result = repository.findByAuthId("local:taeyang").get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setDisplayName("Jin TaeYang");
        member1.setUserName("taeyang");
        member1.setPasswordHash(member1.getUserName() + "password");
        member1.setPasswordSalt(member1.getUserName() + "salt");
        member1.setAuthId("local:" + member1.getUserName());
        repository.save(member1);

        Member member2 = new Member();
        member2.setDisplayName("Spring Framework");
        member2.setUserName("spring");
        member2.setPasswordHash(member2.getUserName() + "password");
        member2.setPasswordSalt(member2.getUserName() + "salt");
        member2.setAuthId("local:" + member2.getUserName());
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}